package com.pandero.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Funcionario {
    @Id
    private Long id;
    private String nombre;

    @OneToMany(mappedBy="funcionario")
    private List<Turno> turnos;

    private boolean activo;
}