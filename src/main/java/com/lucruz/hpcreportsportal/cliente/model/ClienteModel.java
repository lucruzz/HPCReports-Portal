package com.lucruz.hpcreportsportal.cliente.model;

import com.lucruz.hpcreportsportal.cluster.model.ClusterModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/*
Tudo o que estiver abaixo de @Entity
até fechar o colchetes ("}") ou atingir um ";"
será considerado uma entidade.
*/
@Entity // transforma uma classe em uma entidade do BD
@Table(name = "tb_cliente")
@NoArgsConstructor // lombok cria um construtor vazio
@Getter
@Setter
// @AllArgsConstructor // lombok cria um contrutor cheio
// @Data // lombok cria automaticamente os getters e setters
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    // @OneToMany - Um responsável pode ter vários clusters
    @OneToMany(mappedBy = "cliente")
    private List<ClusterModel> clusters;

}
