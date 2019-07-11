package com.pandero.demo.services.funcionariocliente.impl;

import com.pandero.demo.entities.Funcionario;
import com.pandero.demo.entities.FuncionarioCliente;
import com.pandero.demo.repository.FuncionarioClienteRepository;
import com.pandero.demo.services.funcionariocliente.FuncionarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioClienteServiceImpl implements FuncionarioClienteService {

    private FuncionarioClienteRepository funcionarioClienteRepository;

    @Autowired
    public FuncionarioClienteServiceImpl(final FuncionarioClienteRepository funcionarioClienteRepository) {
        this.funcionarioClienteRepository = funcionarioClienteRepository;
    }

    @Override
    public List<FuncionarioCliente> findByFuncionario(Funcionario funcionario) {
        return funcionarioClienteRepository.findByFuncionario(funcionario);
    }
}
