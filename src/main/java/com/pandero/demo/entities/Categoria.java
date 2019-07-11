package com.pandero.demo.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    private Long id;
    private int rango;
    private String descripcion;
    private boolean activo;
}
