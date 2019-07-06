package com.pandero.demo.repository;

import com.pandero.demo.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Turno, Long> {

    Turno findByCodigo(String codigo);


}
