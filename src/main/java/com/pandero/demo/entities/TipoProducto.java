package com.pandero.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class TipoProducto {
    @Id
    private Long id;
    private String descripcion;
    private boolean preferente;
    private boolean activo;
}
