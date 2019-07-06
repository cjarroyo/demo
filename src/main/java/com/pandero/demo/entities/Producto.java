package com.pandero.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Producto {
    @Id
    private Long id;
    private String descripcion;
    @Column(name = "valor_dolares")
    private Double valor;
    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "fk_id_certificado", nullable = false)
    private Certificado certificado;

    @ManyToOne
    @JoinColumn(name = "fk_id_tipo_producto", nullable = false)
    private TipoProducto tipoProducto;
    private boolean activo;
}
