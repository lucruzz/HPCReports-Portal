package com.lucruz.hpcreportsportal.service;

import com.lucruz.hpcreportsportal.model.ClienteModel;
import com.lucruz.hpcreportsportal.model.ClusterModel;
import com.lucruz.hpcreportsportal.model.RelatorioModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    public List<ClienteModel> mostrarInformacoes() {

        RelatorioModel relatorio1 = new RelatorioModel(
                1L,
                "Kronos.pdf",
                "2026-08-01",
                true
        );

        RelatorioModel relatorio2 = new RelatorioModel(
                2L,
                "Zeus.pdf",
                "2026-08-01",
                true
        );

        RelatorioModel relatorio3 = new RelatorioModel(
                3L,
                "Appolo.pdf",
                "2026-08-01",
                false
        );

        ClusterModel cluster1 = new ClusterModel(
                1L,
                "Kronos",
                "kronos.alfa.interno",
                relatorio1

        );
        ClusterModel cluster2 = new ClusterModel(
                2L,
                "Zeus",
                "zeus.alfa.interno",
                relatorio2
        );

        ClusterModel cluster3 = new ClusterModel(
                3L,
                "Apollo",
                "apollo.beta.interno",
                relatorio3
        );

        List<ClusterModel> list1 = List.of(cluster1, cluster2);
        List<ClusterModel> list2 = List.of(cluster3);

        ClienteModel universidadeAlfa = new ClienteModel(
                1L,
                "Universidade Alfa",
                "suporte@alfa.com",
                list1
        );

        ClienteModel institutoBeta = new ClienteModel(
                2L,
                "Instituto Beta",
                "suporte@beta.com",
                list2
        );

        return List.of(universidadeAlfa, institutoBeta);
    }
}
