package com.pandero.demo.services.funcionario.impl;

import com.pandero.demo.entities.Funcionario;
import com.pandero.demo.repository.FuncionarioRepository;
import com.pandero.demo.services.funcionario.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioServiceImpl(final FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public Funcionario findById(Long id) {
        return funcionarioRepository.findByIdAndActivo(id, true);
    }
}
