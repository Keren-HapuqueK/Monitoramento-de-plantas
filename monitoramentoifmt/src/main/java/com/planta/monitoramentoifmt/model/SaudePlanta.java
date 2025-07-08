package com.planta.monitoramentoifmt.model;

public enum SaudePlanta {
    SAUDAVEL("Saudável"),
    PRECISANDO_DE_ATENCAO("Precisando de Atenção"),
    DOENTE("Doente");

    private final String descricao;

    SaudePlanta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}