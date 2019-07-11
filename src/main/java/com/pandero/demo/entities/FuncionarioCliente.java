package com.pandero.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "funcionario_cliente")
public class FuncionarioCliente {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_id_funcionario", nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "fk_id_cliente", nullable = false)
    private Cliente cliente;

    private String tipo;
}
