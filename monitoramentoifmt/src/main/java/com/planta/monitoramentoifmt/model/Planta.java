package com.planta.monitoramentoifmt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomePlanta;
    private String frequenciaRega; // Este pode continuar como String

    @Enumerated(EnumType.STRING) // IMPORTANTE: Salva o NOME do enum no banco ("INTERNA") e não o número (0)
    private Localizacao localizacao;

    @Enumerated(EnumType.STRING) // IMPORTANTE: Salva o NOME do enum no banco ("SAUDAVEL")
    private SaudePlanta saudePlanta;

    // Getters e Setters atualizados para os enums
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomePlanta() { return nomePlanta; }
    public void setNomePlanta(String nomePlanta) { this.nomePlanta = nomePlanta; }
    public String getFrequenciaRega() { return frequenciaRega; }
    public void setFrequenciaRega(String frequenciaRega) { this.frequenciaRega = frequenciaRega; }

    // Getter e Setter para Localizacao
    public Localizacao getLocalizacao() { return localizacao; }
    public void setLocalizacao(Localizacao localizacao) { this.localizacao = localizacao; }

    // Getter e Setter para SaudePlanta
    public SaudePlanta getSaudePlanta() { return saudePlanta; }
    public void setSaudePlanta(SaudePlanta saudePlanta) { this.saudePlanta = saudePlanta; }
}