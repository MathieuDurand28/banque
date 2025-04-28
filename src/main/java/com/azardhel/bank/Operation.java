package com.azardhel.bank;
import java.time.LocalDateTime;
import java.util.UUID;

public class Operation {
    UUID id;
    String titulaire;
    Double solde;
    OperationType type;
    LocalDateTime time; 
    String commentaire = "";

    public Operation(UUID id, String titulaire, Double solde, OperationType type, LocalDateTime time, String commentaire) {
        this.id = id;
        this.titulaire = titulaire;
        this.solde = solde;
        this.type = type;
        this.time = time;
        this.commentaire = commentaire;
    }

}
