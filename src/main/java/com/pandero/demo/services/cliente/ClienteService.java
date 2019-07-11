package com.pandero.demo.services.cliente;

import com.pandero.demo.entities.Cliente;
import com.pandero.demo.entities.FuncionarioCliente;

import java.util.List;

public interface ClienteService {

    Cliente findByDni(String dni);

    Cliente findById(Long id);

    void persistirAtencionConcluida(Cliente cliente);

    List<Cliente> mostrarClientesEnEspera(List<FuncionarioCliente> funcionarioClientes);

}
