package com.azardhel.bank;

public interface BanqueImp  {

    void deposer();
    void retirer() throws SoldeInsuffisantException;
    void transferer() throws CompteInexistantException;

    void addHistory();
    void getAllHistory();
}
