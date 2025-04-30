package com.azardhel.bank;
import java.util.ArrayList;
import java.util.UUID;

public class CompteBancaire {

    private UUID id;
    final private String TITULAIRE;
    private Double solde;
    private ArrayList<Operation> historiqueOperations = new ArrayList<>();

    CompteBancaire(String TITULAIRE, Double solde)
    {
        this.id = UUID.randomUUID();
        this.TITULAIRE = TITULAIRE;
        this.solde = solde;
    }

    UUID getUuid()
    {
        return id;
    }

    String getUidString()
    {
        return id.toString();
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
        System.out.println("-> "+TITULAIRE+" sous l'id: "+getUidString()+" posséde actuellement sur son compte: "+solde+" euros.");
    }


}

