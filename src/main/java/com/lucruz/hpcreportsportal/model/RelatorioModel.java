package com.lucruz.hpcreportsportal.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelatorioModel {
    private Long id;
    private String nome;
    private String data;
    private boolean disponivel;
    private ClusterModel cluster;

    public RelatorioModel(ClusterModel cluster) {
        this.id = null;
        this.cluster = cluster;
        this.nome = cluster.getNome() + ".pdf";
        this.data = null;
        this.disponivel = false;
    }
}
