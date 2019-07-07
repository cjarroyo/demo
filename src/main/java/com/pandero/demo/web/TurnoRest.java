package com.pandero.demo.web;

import com.pandero.demo.entities.Cliente;
import com.pandero.demo.entities.Turno;
import com.pandero.demo.services.cliente.ClienteService;
import com.pandero.demo.services.turno.TurnoService;
import com.pandero.demo.wrapper.TurnoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-mobile")
public class TurnoRest {

    private ClienteService clienteService;
    private TurnoService turnoService;

    @Autowired
    public TurnoRest(final TurnoService turnoService, final ClienteService clienteService) {
        this.turnoService = turnoService;
        this.clienteService = clienteService;
    }

//    @Value("${spring.application.name}")
//    String appName;
//
//    @GetMapping("/")
//    public String homePage(Model model) {
//        model.addAttribute("appName", appName);
//        return "home";
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TurnoResponse generarAtencion(String dni, Boolean preferencial) {
        Cliente cliente = clienteService.findByDni(dni);
        Turno turno = turnoService.generateCodigoYFuncionario(cliente, preferencial);
        return TurnoResponse.builder()
                .codigoAtencion(turno.getCodigo())
                .nombreFuncionario(turno.getFuncionario().getNombre())
                .build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void concluirAtencion(String codigo) {
        turnoService.cerrarAtencion(codigo);
        Cliente cliente = turnoService.obtenerClientePorCodigo(codigo);
        clienteService.persistirAtencionConcluida(cliente);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Cliente> mostrarClientes(Long idFuncionario) {
        return clienteService.obtenerClientesEspera(idFuncionario);
    }


}
