package com.lucruz.hpcreportsportal.service;

import com.lucruz.hpcreportsportal.model.ClienteModel;
import com.lucruz.hpcreportsportal.model.ClusterModel;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

@Service
public class DashboardService {

    public final ObjectMapper objectMapper;

    public DashboardService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void imprimirListaCliente(List<ClienteModel> jsonArray){

        for (ClienteModel cliente : jsonArray) {
            IO.println("Cliente: " + cliente.nome());
            IO.println("Email  : " + cliente.email());

            for (ClusterModel cluster : cliente.clusters()) {
                IO.println("  Cluster : " + cluster.getNome());
                IO.println("  Hostname: " + cluster.getHostname());
                IO.println("  IP      : " + cluster.getIp());
            }
            IO.println("----------------------------");
        }
    }

    public List<ClienteModel> lerJson() {

        File arquivoJson = new File("./src/main/resources/static/data.json");

        List<ClienteModel> jsonArray = objectMapper.readValue(
                arquivoJson,
                new TypeReference<List<ClienteModel>>() {
                }
        );

        for (ClienteModel cliente : jsonArray) {
            for (ClusterModel cluster : cliente.clusters()) {
                cluster.criarRelatorio();
            }
        }
        return jsonArray;
    }
}