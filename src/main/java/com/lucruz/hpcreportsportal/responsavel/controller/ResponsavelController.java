package com.lucruz.hpcreportsportal.responsavel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping // para criar um mapa de rotas
public class ResponsavelController {

    @GetMapping("/")
    public String paginaInicial() {
        return "Esta é a página inicial";
    }


}
