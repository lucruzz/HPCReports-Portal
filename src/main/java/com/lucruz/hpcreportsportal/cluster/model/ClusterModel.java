package com.lucruz.hpcreportsportal.cluster.model;

import com.lucruz.hpcreportsportal.responsavel.model.ResponsavelModel;
import jakarta.persistence.*;

/*
Tudo o que estiver abaixo de @Entity
até fechar o colchetes ("}") ou atingir um ";"
será considerado uma entidade.
*/
@Entity
public class ClusterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String hostname;

    // Um cluster terá um único responsável
    @ManyToOne
    @JoinColumn(name = "cluster_id") // foreing key
    private ResponsavelModel responsavel;

}
