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
    public TurnoServiceImpl(final TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public void generateTurno(Cliente cliente, boolean preferencial) {
        Turno turno = generarTurno(cliente, preferencial);
        persistirTurno(turno);
    }

    public Turno generarTurno(Cliente cliente, boolean preferencial) {
        Turno turno = new Turno();
        turno.setCliente(cliente);
        turno.setPreferente(cliente.isPreferente() || preferencial);
        turno.setEstado("E");
        turno.setFechaIngreso(LocalDateTime.now());
        turno.setIdProducto(cliente.getProducto().getId());
        return turno;
    }

    @Override
    public void atenderCliente(Cliente cliente, Funcionario funcionario) {
        Turno turno = turnoRepository.findByClienteAndEstado(cliente, "E");
        turno.setEstado("A");
        turno.setFuncionario(funcionario);
        turnoRepository.save(turno);
    }

    @Override
    public void concluirAtencion(Cliente cliente) {
        Turno turno = turnoRepository.findByClienteAndEstado(cliente, "A");
        turno.setEstado("C");
        turno.setFechaAtendido(LocalDateTime.now());
        turnoRepository.save(turno);
    }

    private void persistirTurno(Turno turno) {
        turnoRepository.save(turno);
    }

}
