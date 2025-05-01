package com.azardhel.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompteBancaire {

    private UUID id;
    private final String TITULAIRE;
    private Double solde;
    private List<Operation> historiqueOperations = new ArrayList<>();

    public CompteBancaire(String TITULAIRE, Double solde) {
        this.id = UUID.randomUUID();
        this.TITULAIRE = TITULAIRE;
        this.solde = solde;
    }

    public UUID getUuid() {
        return id;
    }

    public String getTitulaire() {
        return TITULAIRE;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double montant) {
        this.solde = montant;
    }

    public void addOperation(Operation o) {
        this.historiqueOperations.add(o);
    }

    public List<Operation> getHistorique() {
        return historiqueOperations;
    }
}