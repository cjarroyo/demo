package com.pandero.demo.repository;

import com.pandero.demo.entities.Cliente;
import com.pandero.demo.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurnoRepository extends JpaRepository<Turno, Long> {

    Turno findByClienteAndEstado(Cliente cliente, String estado);

    List<Turno> findByEstado(String estado);


}
