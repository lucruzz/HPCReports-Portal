package com.lucruz.hpcreportsportal.controller;

import com.lucruz.hpcreportsportal.service.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    public final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/")
    public String mostrarDashboard(Model model) {
        model.addAttribute(
                "clientes",
                // dashboardService.mostrarInformacoes()
                dashboardService.lerJson()
        );
        return "dashboard";
    }
}
