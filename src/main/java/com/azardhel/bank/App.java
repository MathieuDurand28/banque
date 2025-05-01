package com.azardhel.bank;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CompteBancaire account1 = new CompteBancaire("Mathieu", 2500.0);
        CompteBancaire account2 = new CompteBancaire("Rodolf", 46000.0);

        System.out.println("Solde compte1: "+account1.getSolde());
        System.out.println("Solde compte2: "+account2.getSolde());
        
        BanqueService serviceBancaire = new BanqueService();
        serviceBancaire.ajouterCompte(account1);
        serviceBancaire.ajouterCompte(account2);

        try {
            serviceBancaire.deposer(account1.getUuid(), 500.0);
        } catch (CompteInexistantException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            serviceBancaire.deposer(account2.getUuid(), 20.0);
        } catch (CompteInexistantException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            serviceBancaire.transferer(account2.getUuid(), account1.getUuid(), 10000.0);
        } catch (CompteInexistantException | SoldeInsuffisantException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("Solde compte1 après: "+account1.getSolde());
        System.out.println("Solde compte2 après: "+account2.getSolde());

        account1.getAllHistory();
        account2.getAllHistory();

    }
}
