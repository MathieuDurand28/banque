package com.azardhel.bank;

import java.time.LocalDateTime;
import java.util.*;

public class BanqueService implements BanqueImp {
    private Map<UUID, CompteBancaire> comptes = new HashMap<>();
    
    public void ajouterCompte(CompteBancaire compte) {
        comptes.put(compte.getUuid(), compte);
        compte.setHistory(
            new Operation(
            compte.getUuid(), 
            compte.getTitulaire(), 
            compte.getSolde(), 
            OperationType.CREATE, 
            LocalDateTime.now(), 
            "Ajout d'un compte bancaire")
        );
        
    }

    @Override
    public void deposer(UUID id, double montant) throws CompteInexistantException {
        CompteBancaire compte = comptes.get(id);
        if (compte == null) throw new CompteInexistantException("ID inconnu");
        compte.setSolde(compte.getSolde() + montant);
        compte.setHistory(
            new Operation(
            compte.getUuid(), 
            compte.getTitulaire(), 
            compte.getSolde(), 
            OperationType.DEPOSIT, 
            LocalDateTime.now(), 
            "Dépot sur le compte: "+compte.getTitulaire()+" de la somme de: "+montant+" Euros")
        );
        
    }

    @Override
    public void retirer(UUID id, double montant) throws SoldeInsuffisantException {
        CompteBancaire compte = comptes.get(id);
        if (compte.getSolde() < montant) throw new SoldeInsuffisantException("Solde insuffisant pour effectuer l'opération");
        compte.setSolde(compte.getSolde() - montant);
        compte.setHistory(
            new Operation(
            compte.getUuid(), 
            compte.getTitulaire(), 
            compte.getSolde(), 
            OperationType.WITHDRAW, 
            LocalDateTime.now(), 
            "Retrait sur le compte: "+compte.getTitulaire()+" de la somme de: "+montant+" Euros")
        );
    }

    @Override
    public void transferer(UUID FromId,UUID ToId, double montant) throws CompteInexistantException, SoldeInsuffisantException {
        CompteBancaire fromCompte = comptes.get(FromId);
        CompteBancaire toCompte = comptes.get(ToId);
        if (fromCompte == null || toCompte == null) throw new CompteInexistantException("Compte inexistant");
        if (fromCompte.getSolde() < montant) throw new SoldeInsuffisantException("Solde insuffisant pour effectuer le transfert");

        fromCompte.setSolde(fromCompte.getSolde() - montant);
        toCompte.setSolde(toCompte.getSolde() + montant);
        fromCompte.setHistory(
            new Operation(
            fromCompte.getUuid(), 
            fromCompte.getTitulaire(), 
            fromCompte.getSolde(), 
            OperationType.TRANSFER, 
            LocalDateTime.now(), 
            "Transfert d'argent entre "+fromCompte.getTitulaire()+" et "+toCompte.getTitulaire()+" - "+montant+" Euros envoyé"+
            " -- \n -> Nouveaux soldes <- \n "+fromCompte.getTitulaire()+" = "+fromCompte.getSolde()+"\n"+toCompte.getTitulaire()+" = "+toCompte.getSolde())
        );
    }

}