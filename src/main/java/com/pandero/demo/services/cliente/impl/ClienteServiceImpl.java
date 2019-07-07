package com.pandero.demo.services.cliente.impl;

import com.pandero.demo.entities.Cliente;
import com.pandero.demo.repository.ClienteRepository;
import com.pandero.demo.services.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(final ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    @Override
    public Cliente findByDni(String dni) {
        return clienteRepository.findByDniAndActivo(dni, true);
    }

    @Override
    public void persistirAtencionConcluida(Cliente cliente) {
        cliente.setFechaUltimaVisita(LocalDateTime.now());
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerClientesEspera(Long idFuncionario) {
        //return clienteRepository.obtenerClientes(idFuncionario);
        return null;
    }
}
