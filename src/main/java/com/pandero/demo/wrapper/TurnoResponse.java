package com.pandero.demo.wrapper;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TurnoResponse {
    private String codigoAtencion;
    private String nombreFuncionario;
}
