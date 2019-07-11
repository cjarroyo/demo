package com.pandero.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Certificado {
    @Id
    private Long id;
    private String descripcion;
    private Double valor;
    private boolean activo;
}
