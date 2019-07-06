package com.pandero.demo.services.turno;

import com.pandero.demo.entities.Cliente;
import com.pandero.demo.entities.Turno;

public interface TurnoService {

    Turno generateCodigoYFuncionario(Cliente cliente, boolean preferencial);

    void cerrarAtencion(String coodigo);

    Cliente obtenerClientePorCodigo(String codigo);
}
