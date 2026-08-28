package com.lucruz.hpcreportsportal.model;

import java.util.List;

public record ClienteModel(
        Long id,
        String nome,
        String email,
        List<ClusterModel> clusters
){
}