package com.tawssil.delivery.service;

import com.tawssil.delivery.model.Livraison;
import com.tawssil.delivery.model.Livreur;
import com.tawssil.delivery.repository.LivraisonRepository;
import com.tawssil.delivery.repository.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreurService {

    @Autowired
    private LivreurRepository livreurRepository;

    @Autowired
    private LivraisonRepository livraisonRepository;

    // Gérer la disponibilité
    public void gererDisponibilite(Long livreurId, boolean disponibilite) {
        Livreur livreur = livreurRepository.findById(livreurId)
                .orElseThrow(() -> new RuntimeException("Livreur non trouvé"));
        livreur.setDisponible(disponibilite);
        livreurRepository.save(livreur);
    }

    // Voir les commandes affectées
    public List<Livraison> voirCommandesAffectees(Long livreurId) {
        return livraisonRepository.findByLivreurId(livreurId);
    }

    // Mettre à jour le statut des livraisons
    public Livraison mettreAJourStatutLivraison(Long livraisonId, String statut) {
        Livraison livraison = livraisonRepository.findById(livraisonId)
                .orElseThrow(() -> new RuntimeException("Livraison non trouvée"));
        livraison.setStatut(statut);
        return livraisonRepository.save(livraison);
    }
}
