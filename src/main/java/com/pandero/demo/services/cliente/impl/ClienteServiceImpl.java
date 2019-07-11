package com.pandero.demo.services.cliente.impl;

import com.pandero.demo.entities.Cliente;
import com.pandero.demo.entities.FuncionarioCliente;
import com.pandero.demo.entities.Turno;
import com.pandero.demo.repository.ClienteRepository;
import com.pandero.demo.repository.TurnoRepository;
import com.pandero.demo.services.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    private TurnoRepository turnoRepository;

    @Autowired
    public ClienteServiceImpl(final ClienteRepository clienteRepository, final TurnoRepository turnoRepository) {
        this.clienteRepository = clienteRepository;
        this.turnoRepository = turnoRepository;
    }

    @Override
    public Cliente findByDni(String dni) {
        return clienteRepository.findByDniAndActivo(dni, true);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findByIdAndActivo(id, true);
    }

    @Override
    public void persistirAtencionConcluida(Cliente cliente) {
        cliente.setFechaUltimaVisita(LocalDateTime.now());
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> mostrarClientesEnEspera(List<FuncionarioCliente> funcionarioClientes) {
        List<Cliente> clientesByFuncionario = this.obtenerClientesPorFuncionario(funcionarioClientes);
        List<Turno> turnosEnEspera = this.obtenerClientesEnEspera(clientesByFuncionario);

        return obtenerListaOrdenada(turnosEnEspera);
    }

    private List<Cliente> obtenerListaOrdenada(List<Turno> turnosEnEspera) {
        List<Turno> listaVip = this.obtenerListaVip(turnosEnEspera);
        List<Turno> listaMenosVip = removerVip(turnosEnEspera, listaVip);
        List<Turno> listaPreferencial = this.obtenerListaPreferencial(listaMenosVip);
        List<Turno> listaNotmal = this.obtenerListaNormal(listaMenosVip);
        List<Turno> listaCompleta = unirListas(listaVip, listaPreferencial, listaNotmal);
        return devolverClientes(listaCompleta);

    }

    private List<Turno> removerVip(List<Turno> turnosEnEspera, List<Turno> listaVip) {
        for(Turno turno: listaVip){
            turnosEnEspera.remove(turno.getId());
        }
        return turnosEnEspera;
    }

    private List<Cliente> devolverClientes(List<Turno> listaCompleta) {
        List<Cliente> lista = new ArrayList<>();
        for (Turno turno : listaCompleta) {
            lista.add(turno.getCliente());
        }
        return lista;
    }

    private List<Turno> unirListas(List<Turno> listaVip, List<Turno> listaPreferencial, List<Turno> listaNotmal) {
        List<Turno> lista = new ArrayList<>();
        lista.addAll(listaVip);
        lista.addAll(listaPreferencial);
        lista.addAll(listaNotmal);
        return lista;
    }

    private List<Turno> obtenerListaVip(List<Turno> clientesParaAtender) {
        List<Turno> listaVip = new ArrayList<>();
        for (Turno turno : clientesParaAtender) {
            if (turno.getIdProducto() == 1L) {
                listaVip.add(turno);
            }
        }
        listaVip.sort((Turno h1, Turno h2) -> h1.getFechaIngreso().compareTo(h2.getFechaIngreso()));
        return listaVip;
    }

    private List<Turno> obtenerListaPreferencial(List<Turno> clientesParaAtender) {
        List<Turno> listaPreferencial = new ArrayList<>();
        for (Turno turno : clientesParaAtender) {
            if (turno.isPreferente() && turno.getIdProducto() != 1L) {
                listaPreferencial.add(turno);
            }
        }
        listaPreferencial.sort((Turno h1, Turno h2) -> h1.getFechaIngreso().compareTo(h2.getFechaIngreso()));
        return listaPreferencial;
    }

    private List<Turno> obtenerListaNormal(List<Turno> clientesParaAtender) {
        List<Turno> listaNormal = new ArrayList<>();
        for (Turno turno : clientesParaAtender) {
            if (!turno.isPreferente() && turno.getIdProducto() != 1L) {
                listaNormal.add(turno);
            }
        }
        listaNormal.sort((Turno h1, Turno h2) -> h1.getFechaIngreso().compareTo(h2.getFechaIngreso()));
        return listaNormal;
    }

    private List<Turno> obtenerClientesEnEspera(List<Cliente> clientesByFuncionario) {//13
        List<Turno> turnosEnEspera = turnoRepository.findByEstado("E");//38
        List<Turno> clientesPorFuncionarioEnEspera = new ArrayList<>();
        for (Cliente cliente : clientesByFuncionario) {
            for (Turno turno : turnosEnEspera) {
                if (cliente.getId().equals(turno.getCliente().getId())) {
                    clientesPorFuncionarioEnEspera.add(turno);
                }
            }

        }
        return clientesPorFuncionarioEnEspera;
    }

    private List<Cliente> obtenerClientesPorFuncionario(List<FuncionarioCliente> funcionarioClientes) {
        List<Cliente> clientes = new ArrayList<>();
        for (FuncionarioCliente funcionarioCliente : funcionarioClientes) {
            clientes.add(funcionarioCliente.getCliente());
        }
        return clientes;
    }
}
