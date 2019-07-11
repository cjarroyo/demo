package com.pandero.demo.web;

import com.pandero.demo.entities.Cliente;
import com.pandero.demo.entities.Funcionario;
import com.pandero.demo.entities.FuncionarioCliente;
import com.pandero.demo.services.cliente.ClienteService;
import com.pandero.demo.services.funcionario.FuncionarioService;
import com.pandero.demo.services.funcionariocliente.FuncionarioClienteService;
import com.pandero.demo.services.turno.TurnoService;
import com.pandero.demo.wrapper.TurnoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoRest {
    private ClienteService clienteService;
    private TurnoService turnoService;
    private FuncionarioService funcionarioService;
    private FuncionarioClienteService funcionarioClienteService;

    @Autowired
    public TurnoRest(final TurnoService turnoService,
                     final ClienteService clienteService,
                     final FuncionarioService funcionarioService,
                     final FuncionarioClienteService funcionarioClienteService) {
        this.turnoService = turnoService;
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
        this.funcionarioClienteService = funcionarioClienteService;
    }

    @PostMapping("/genera")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void generarTurno(@RequestBody TurnoRequest turnoRequest) {
        Cliente cliente = clienteService.findByDni(turnoRequest.getDni());
        turnoService.generateTurno(cliente, turnoRequest.getPreferencial());
    }


    @GetMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Cliente> mostrarClientes(@PathVariable long id) {
        Funcionario funcionario = funcionarioService.findById(id);
        List<FuncionarioCliente> funcionarioClientes = funcionarioClienteService.findByFuncionario(funcionario);
        return clienteService.mostrarClientesEnEspera(funcionarioClientes);
    }


    @PatchMapping("/atender/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void atenderCliente(@PathVariable Long id) {
        //por session traer el id del funcionario
        Funcionario funcionario = funcionarioService.findById(2L);
        Cliente cliente = clienteService.findById(id);
        turnoService.atenderCliente(cliente, funcionario);
    }


    @PatchMapping("/cerrar/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void concluirAtencion(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        turnoService.concluirAtencion(cliente);
        clienteService.persistirAtencionConcluida(cliente);
    }
}
