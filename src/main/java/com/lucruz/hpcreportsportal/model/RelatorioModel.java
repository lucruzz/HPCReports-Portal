package com.lucruz.hpcreportsportal.model;

public record RelatorioModel(
        Long id,
        String nome,
        String data,
        boolean disponivel
) {
}
