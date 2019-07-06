package com.pandero.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
public class Turno {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fk_id_funcionario", nullable = false)
    private Funcionario funcionario;

    private boolean preferente;
    private String codigo;
    private boolean atendido;

    @Column(name = "fec_ingreso")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime fechaIngreso;

    @Column(name = "fec_atendido")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime fechaAtendido;

}
