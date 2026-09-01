package com.lucruz.hpcreportsportal.model;

public enum RelatorioStatus {

    NAO_VERIFICADO("Não verificado"),
    DISPONIVEL("Disponível"),
    NAO_ENCONTRADO("Não encontrado"),
    ERRO_CONEXAO("Erro de conexão");

    private final String descricao;

    RelatorioStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
