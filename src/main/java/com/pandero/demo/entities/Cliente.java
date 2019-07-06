package com.pandero.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Cliente {
    @Id
    private Long id;
    private String dni;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "fk_id_categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "fecha_ult_visita")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime fechaUltimaVisita;

    private boolean preferente;

    @ManyToOne
    @JoinColumn(name = "fk_id_producto", nullable = false)
    private Producto producto;

    private boolean activo;
}
