package com.lucruz.hpcreportsportal.cluster.model;

import com.lucruz.hpcreportsportal.relatorio.model.RelatorioModel;
import com.lucruz.hpcreportsportal.cliente.model.ClienteModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_cluster")
@NoArgsConstructor
// @AllArgsConstructor
// @Data
@Getter
@Setter
public class ClusterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String hostname;

    // @ManyToOne - Dos muitos cluster existentes estarão associados a um único responsável
    @ManyToOne
    @JoinColumn(name = "cluster_id") // foreing key
    private ClienteModel cliente;

    @OneToMany(mappedBy = "cluster")
    private List<RelatorioModel> relatorios;

}
