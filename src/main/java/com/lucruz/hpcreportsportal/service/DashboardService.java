package com.lucruz.hpcreportsportal.service;

import com.lucruz.hpcreportsportal.integration.ssh.SSHChecker;
import com.lucruz.hpcreportsportal.model.ClienteModel;
import com.lucruz.hpcreportsportal.model.ClusterModel;
import com.lucruz.hpcreportsportal.model.RelatorioStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

@Service
@Getter
@Setter
public class DashboardService {

    private final ObjectMapper objectMapper;
    private List<ClienteModel> clientes;
    private final SSHChecker sshChecker;

    public DashboardService(ObjectMapper objectMapper,
                            SSHChecker sshChecker
    ) {
        this.objectMapper = objectMapper;
        this.sshChecker = sshChecker;
        this.clientes = orquestradorDeClientes();
    }

    public void imprimirListaCliente(List<ClienteModel> jsonArray){

        for (ClienteModel cliente : jsonArray) {
            IO.println("Cliente: " + cliente.getNome());
            IO.println("Email  : " + cliente.getEmail());

            for (ClusterModel cluster : cliente.getClusters()) {
                IO.println("  Cluster : " + cluster.getNome());
                IO.println("  Hostname: " + cluster.getHostname());
                IO.println("  IP      : " + cluster.getIp());
            }
            IO.println("----------------------------");
        }
    }

    public List<ClienteModel> lerJson() {

        File arquivoJson = new File("./src/main/resources/data/data.json");

        return objectMapper.readValue(
                arquivoJson,
                new TypeReference<List<ClienteModel>>() {
                }
        );

    }

    public List<ClienteModel> orquestradorDeClientes() {

        this.clientes = lerJson();

        atualizarStatusRelatorio();

        return this.clientes;
    }

    public void atualizarStatusRelatorio() {

        Long counterID = 0L;
        for (ClienteModel cliente : this.clientes) {
            for (ClusterModel cluster : cliente.getClusters()) {
                cluster.setId(counterID++);
                cluster.criarRelatorio();
                verificarRelatorio(cluster.getId());
            }
        }
    }

    public void verificarRelatorio(Long id) {
        ClusterModel cluster = buscarClusterPorID(id);
        if ( cluster == null ) {
            throw new IllegalArgumentException("Cluster não encontrado: " + id);
        } else {
            RelatorioStatus resultado = sshChecker.verificar(cluster.getIp());
            cluster.getRelatorio().setStatus(resultado);
        }
    }

    public ClusterModel buscarClusterPorID(Long id) {

        for ( ClienteModel cliente : this.clientes ) {
            for ( ClusterModel cluster : cliente.getClusters() ) {
                if ( cluster.getId().equals(id) ) {
                    return cluster;
                }
            }
        }
        return null;
    }
}