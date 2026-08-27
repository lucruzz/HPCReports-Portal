package com.lucruz.hpcreportsportal.cliente.controller;

import com.lucruz.hpcreportsportal.cliente.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
@Controller
@RequestMapping // para criar um mapa de rotas
public class ClienteController {

//    @GetMapping("/")
//    public String paginaInicial() {
//     return "Esta é a página inicial";
//    }

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public String listarClientes(Model model){
        model.addAttribute(
                "clientes",
                clienteService.listarClientes()
        );

        return "clientes";
    }

}
