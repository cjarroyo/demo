package com.pandero.demo.services.cliente;

import com.pandero.demo.entities.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente findByDni(String dni);

    void persistirAtencionConcluida(Cliente cliente);

    List<Cliente> obtenerClientesEspera(Long idFuncionario);
}
