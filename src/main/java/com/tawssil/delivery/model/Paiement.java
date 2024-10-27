package com.tawssil.delivery.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;

    @Temporal(TemporalType.DATE)
    private Date datePaiement;

    private String mode;

    private String statut;

    @ManyToOne
    @JoinColumn(name = "commande_id", referencedColumnName = "id")
    private commande commande;

    // Getters and Setters
}
