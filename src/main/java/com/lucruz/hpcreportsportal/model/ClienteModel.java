package com.lucruz.hpcreportsportal.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteModel {

    private Long id;
    private String nome;
    private String email;
    private List<ClusterModel> clusters;

}