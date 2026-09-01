package com.lucruz.hpcreportsportal.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClusterModel {
    private Long id;
    private String nome;
    private String hostname;
    private String ip;
    private RelatorioModel relatorio;

    public RelatorioModel criarRelatorio(){
        this.relatorio = new RelatorioModel(this);
        return this.relatorio;
    }
}