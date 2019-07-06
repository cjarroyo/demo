package com.pandero.demo.repository;

import com.pandero.demo.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByDniAndActivo(String dni, boolean activo);

    @Query("SELECT * FROM bdturno.TURNO where fk_id_funcionario = idFuncionario  order by fec_ingreso;")
    List<Cliente> obtenerClientes(Long idFuncionario);
}
