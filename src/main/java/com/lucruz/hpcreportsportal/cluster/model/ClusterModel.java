package com.lucruz.hpcreportsportal.cluster.model;

/*
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
    // Na tabela "tb_cluster", existe uma coluna chamada "cliente_id" que referencia o
    // cliente deste cluster
    @JoinColumn(name = "cluster_id") // foreing key
    private ClienteModel cliente;

    @OneToMany(mappedBy = "cluster")
    private List<RelatorioModel> relatorios;

}
*/
public record ClusterModel(
        Long id,
        String nome,
        String hostname
){
}