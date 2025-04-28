package com.azardhel.bank;
import java.util.ArrayList;
import java.util.UUID;

public class CompteBancaire {

    private UUID id = UUID.randomUUID();
    final private String TITULAIRE;
    private Double solde;
    private ArrayList<Operation> historiqueOperations = new ArrayList<>();

    CompteBancaire(String TITULAIRE, Double solde)
    {
        this.TITULAIRE = TITULAIRE;
        this.solde = solde;
    }

    String getTitulaire()
    {
        return TITULAIRE;
    }

    Double getSolde()
    {
        return solde;
    }

    void getAllInfos()
    {
        System.out.println("-> "+TITULAIRE+" sous l'id: "+id.toString()+" posséde actuellement sur son compte: "+solde+" euros.");
    }


}

