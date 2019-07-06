package com.pandero.demo.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@Builder
public class Funcionario {
    @Id
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_id_backup", nullable = false)
    private Funcionario backup;
    private boolean activo;

}
