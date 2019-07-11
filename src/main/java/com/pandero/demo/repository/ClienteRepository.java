package com.pandero.demo.repository;

import com.pandero.demo.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByDniAndActivo(String dni, boolean activo);

    Cliente findByIdAndActivo(Long id, boolean activo);

}
