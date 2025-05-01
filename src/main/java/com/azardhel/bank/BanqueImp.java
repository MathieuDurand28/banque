package com.azardhel.bank;

import java.util.UUID;

public interface BanqueImp  {

    void deposer(UUID id, double montant) throws CompteInexistantException;
    void retirer(UUID id, double montant) throws SoldeInsuffisantException;
    void transferer(UUID fromId, UUID toId, double montant) throws CompteInexistantException, SoldeInsuffisantException;

}
