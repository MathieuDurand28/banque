package com.azardhel.bank;

public class App {
    public static void main(String[] args) {
        CompteBancaire account1 = new CompteBancaire("Mathieu", 2500.0);
        CompteBancaire account2 = new CompteBancaire("Rodolf", 46000.0);

        BanqueService serviceBancaire = new BanqueService();
        serviceBancaire.ajouterCompte(account1);
        serviceBancaire.ajouterCompte(account2);

        try {
            serviceBancaire.deposer(account1.getUuid(), 500.0);
            serviceBancaire.deposer(account2.getUuid(), 20.0);
            serviceBancaire.transferer(account2.getUuid(), account1.getUuid(), 10000.0);
        } catch (CompteInexistantException | SoldeInsuffisantException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        //System.out.println("Solde compte1 après: " + account1.getSolde());
        //System.out.println("Solde compte2 après: " + account2.getSolde());

        for (Operation op : account1.getHistorique()) {
            System.out.println(op.commentaire);
        }
        for (Operation op : account2.getHistorique()) {
            System.out.println(op.commentaire);
        }
    }
}