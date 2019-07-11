package com.pandero.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoProducto {
    @Id
    private Long id;
    private String descripcion;
    private boolean preferente;
    private boolean activo;
}
