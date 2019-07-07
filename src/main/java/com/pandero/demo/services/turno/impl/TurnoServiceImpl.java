package com.pandero.demo.services.turno.impl;

import com.pandero.demo.entities.Cliente;
import com.pandero.demo.entities.Funcionario;
import com.pandero.demo.entities.Turno;
import com.pandero.demo.repository.TurnoRepository;
import com.pandero.demo.services.turno.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TurnoServiceImpl implements TurnoService {

    private TurnoRepository turnoRepository;

    @Autowired
    public TurnoServiceImpl(final TurnoRepository turnoRepository){
        this.turnoRepository = turnoRepository;
    }

    @Override
    public Turno generateCodigoYFuncionario(Cliente cliente, boolean preferencial) {
        Turno turno = generarTurno(cliente, preferencial);
        persistirTurno(turno);
        return turno;
    }

    @Override
    public void cerrarAtencion(String codigo) {
        Turno turno = turnoRepository.findByCodigo(codigo);
        turno.setAtendido(true);
        turno.setFechaAtendido(LocalDateTime.now());
        turnoRepository.save(turno);
    }

    @Override
    public Cliente obtenerClientePorCodigo(String codigo) {
        return turnoRepository.findByCodigo(codigo).getCliente();
    }

    private void persistirTurno(Turno turno) {
        turnoRepository.save(turno);
    }

    public Turno generarTurno(Cliente cliente, boolean preferencial) {
        //TODO: usando threads genero el codigo de atencion
        // (aqui verifico que funcionario esta mas disponible, segun su preferencia y segun el tipo de producto
        // y que teenga como maximo 10)
        String codigo = "PRE-001";
        Funcionario funcionario = Funcionario.builder().build();
        return Turno.builder()
                .cliente(cliente)
                .funcionario(funcionario)
                .preferente(true)
                .codigo(codigo)
                .atendido(false)
                .fechaIngreso(LocalDateTime.now())
                .build();
    }
}
