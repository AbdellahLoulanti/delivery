package com.tawssil.delivery.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adresseLivraison;

    @Temporal(TemporalType.DATE)
    private Date dateLivraison;

    private String statut;

    @ManyToOne
    @JoinColumn(name = "commande_id", referencedColumnName = "id")
    private commande commande;  // Utilisé en minuscule

    @ManyToOne
    @JoinColumn(name = "livreur_id", referencedColumnName = "id")
    private Livreur livreur;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public commande getCommande() {
        return commande;
    }

    public void setCommande(commande commande) {
        this.commande = commande;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }
}
