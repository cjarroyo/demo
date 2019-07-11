package com.pandero.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fk_id_funcionario", nullable = false)
    private Funcionario funcionario;

    private boolean preferente;
    private String codigo;
    private String estado;

    @Column(name = "fec_ingreso")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime fechaIngreso;

    @Column(name = "fec_atendido")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime fechaAtendido;

    @Column(name = "id_producto")
    private Long idProducto;

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}
