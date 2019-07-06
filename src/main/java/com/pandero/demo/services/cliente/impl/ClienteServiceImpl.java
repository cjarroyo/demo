package com.pandero.demo.services.cliente.impl;

import com.pandero.demo.entities.Cliente;
import com.pandero.demo.repository.ClienteRepository;
import com.pandero.demo.services.cliente.ClienteService;

import java.time.LocalDateTime;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

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
        return clienteRepository.obtenerClientes(idFuncionario);
    }
}
