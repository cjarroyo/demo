package com.pandero.demo.repository;

import com.pandero.demo.entities.Cliente;
import com.pandero.demo.entities.Funcionario;
import com.pandero.demo.entities.FuncionarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioClienteRepository extends JpaRepository<FuncionarioCliente, Long> {

    FuncionarioCliente findByClienteAndTipo(Cliente cliente, String tipo);

    List<FuncionarioCliente> findByFuncionario(Funcionario funcionario);

}
