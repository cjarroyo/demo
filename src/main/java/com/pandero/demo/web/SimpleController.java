package com.pandero.demo.web;

import com.pandero.demo.entities.Cliente;
import com.pandero.demo.entities.Turno;
import com.pandero.demo.services.cliente.ClienteService;
import com.pandero.demo.services.turno.TurnoService;
import com.pandero.demo.wrapper.TurnoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SimpleController {

    private ClienteService clienteService;
    private TurnoService turnoService;

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    public TurnoResponse generarAtencion(String dni, boolean preferencial) {
        Cliente cliente = clienteService.findByDni(dni);
        Turno turno = turnoService.generateCodigoYFuncionario(cliente, preferencial);
        return TurnoResponse.builder()
                .codigoAtencion(turno.getCodigo())
                .nombreFuncionario(turno.getFuncionario().getNombre())
                .build();
    }

    public void concluirAtencion(String codigo) {
        turnoService.cerrarAtencion(codigo);
        Cliente cliente = turnoService.obtenerClientePorCodigo(codigo);
        clienteService.persistirAtencionConcluida(cliente);
    }


    public List<Cliente> mostrarClientes(Long idFuncionario) {
        return clienteService.obtenerClientesEspera(idFuncionario);
    }


}
