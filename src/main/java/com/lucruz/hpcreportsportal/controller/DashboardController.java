package com.lucruz.hpcreportsportal.controller;

import com.lucruz.hpcreportsportal.integration.ssh.SSHChecker;
import com.lucruz.hpcreportsportal.service.DashboardService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Getter
@Setter
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/")
    public String mostrarDashboard(Model model) {
        model.addAttribute(
                "clientes",
                // dashboardService.mostrarInformacoes()
                dashboardService.getClientes()
                // dashboardService.orquestradorDeClientes()
        );
        return "dashboard";
    }

    @PostMapping("/clusters/{id}/relatorio/verificar")
    public String verificarRelatorio(@PathVariable Long id) {
        dashboardService.verificarRelatorio(id);

        return "redirect:/";
    }
}
