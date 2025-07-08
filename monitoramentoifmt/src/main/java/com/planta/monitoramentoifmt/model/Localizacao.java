package com.planta.monitoramentoifmt.model;

public enum Localizacao {
    INTERNA("Interna"),
    EXTERNA("Externa");

    private final String descricao;

    Localizacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}