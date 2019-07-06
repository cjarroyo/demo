package com.pandero.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Certificado {
    @Id
    private Long id;
    private String descripcion;
    private Double valor;
    private boolean activo;
}
