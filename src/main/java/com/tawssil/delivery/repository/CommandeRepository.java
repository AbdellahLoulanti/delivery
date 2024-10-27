package com.tawssil.delivery.repository;

import com.tawssil.delivery.model.commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<commande, Long> {
    List<commande> findByClientId(Long clientId); // Pour récupérer les commandes d'un client spécifique
}
