package com.tawssil.delivery.model;

import jakarta.persistence.*;

@Entity
public class Livreur extends Utilisateur {

    private boolean disponibilite;

    // Getters and Setters
    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponible(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }
}
