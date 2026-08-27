/*
package com.lucruz.hpcreportsportal.relatorio.model;

import com.lucruz.hpcreportsportal.cluster.model.ClusterModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_relatorio")
@NoArgsConstructor
// @AllArgsConstructor
// @Data
@Getter
@Setter
public class RelatorioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String data;
    private boolean disponivel;

    // @ManyToOne - Os muitos relatorio existentes estarão associados a um único cluster
    @ManyToOne
    @JoinColumn(name = "relatorio_id")
    private ClusterModel cluster;

}
*/
