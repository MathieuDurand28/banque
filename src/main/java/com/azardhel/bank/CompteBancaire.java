package com.azardhel.bank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CompteBancaire {

    private UUID id;
    final private String TITULAIRE;
    private Double solde;
    private Map<UUID, Operation> historiqueOperations = new HashMap<>();

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

    void setSolde(Double montant)
    {
        this.solde = montant;
    }

    void getAllInfos()
    {
        System.out.println("-> "+TITULAIRE+" sous l'id: "+getUidString()+" posséde actuellement sur son compte: "+solde+" euros.");
    }

    void getAllHistory()
    {
        for (Operation op : historiqueOperations.values()){
            System.out.println(op.commentaire+"\n");
        }
    }

    void setHistory(Operation o)
    {
        this.historiqueOperations.put(this.id,o);
    }


}

