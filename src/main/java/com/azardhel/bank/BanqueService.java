package com.azardhel.bank;

public class BanqueService extends CompteBancaire implements BanqueImp {
    
    BanqueService(String titulaire, Double solde)
    {
        super(titulaire, solde);
    }

    @Override
    public void deposer()
    {
        
    }

    @Override
    public void retirer() throws SoldeInsuffisantException
    {
        if (true){
            throw new SoldeInsuffisantException("Pas de thune");
        }   
    }

    @Override
    public void transferer() throws CompteInexistantException
    {
        if (true){
            throw new CompteInexistantException("utilisateur Inconnu");
        } 
    }

    @Override
    public void addHistory()
    {

    }

    @Override
    public void getAllHistory()
    {

    }
   
}
