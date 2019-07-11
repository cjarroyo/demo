package com.pandero.demo.repository;

import com.pandero.demo.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByIdAndActivo(Long id, Boolean activo);

}
