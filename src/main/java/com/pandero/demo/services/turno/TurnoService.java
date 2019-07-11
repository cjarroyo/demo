package com.pandero.demo.services.turno;

        import com.pandero.demo.entities.Cliente;
        import com.pandero.demo.entities.Funcionario;

public interface TurnoService {

    void generateTurno(Cliente cliente, boolean preferencial);

    void atenderCliente(Cliente cliente, Funcionario funcionario);

    void concluirAtencion(Cliente cliente);

}
