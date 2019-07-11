package com.pandero.demo.services.funcionariocliente;

import com.pandero.demo.entities.Funcionario;
import com.pandero.demo.entities.FuncionarioCliente;

import java.util.List;

public interface FuncionarioClienteService {

    List<FuncionarioCliente> findByFuncionario(Funcionario funcionario);
}
