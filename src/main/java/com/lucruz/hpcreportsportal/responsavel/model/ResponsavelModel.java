package com.lucruz.hpcreportsportal.responsavel.model;

import com.lucruz.hpcreportsportal.cluster.model.ClusterModel;
import jakarta.persistence.*;

import java.util.List;

@Entity // transforma uma classe em uma entidade do BD
@Table(name = "tb_responsavel")
public class ResponsavelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;

    // Um responsável pode ter vários clusters
    @OneToMany(mappedBy = "responsavel")
    private List<ClusterModel> clusters;


    public ResponsavelModel() {
    }

    public ResponsavelModel(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
