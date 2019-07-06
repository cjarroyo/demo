package com.pandero.demo.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Categoria {

    @Id
    private Long id;
    private int rango;
    private String descripcion;
    private boolean activo;
}
