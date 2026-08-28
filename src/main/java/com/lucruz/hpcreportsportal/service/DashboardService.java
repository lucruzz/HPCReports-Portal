package com.lucruz.hpcreportsportal.service;

import com.lucruz.hpcreportsportal.model.ClienteModel;
import com.lucruz.hpcreportsportal.model.ClusterModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    public List<ClienteModel> mostrarInformacoes() {

        ClusterModel cluster1 = new ClusterModel(
                1L,
                "Kronos",
                "kronos.alfa.interno"
        );
        ClusterModel cluster2 = new ClusterModel(
                2L,
                "Zeus",
                "zeus.alfa.interno"
        );

        ClusterModel cluster3 = new ClusterModel(
                3L,
                "Apollo",
                "apollo.beta.interno"
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
