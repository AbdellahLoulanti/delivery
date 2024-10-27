package com.tawssil.delivery.service;
import com.tawssil.delivery.model.Client;
import com.tawssil.delivery.model.commande;
import com.tawssil.delivery.model.Livraison;
import com.tawssil.delivery.repository.CommandeRepository;
import com.tawssil.delivery.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private LivraisonRepository livraisonRepository;

    //afficher commandes

    public List<commande> obtenirTousLesCommandes() {
        return commandeRepository.findAll();
    }

    public Optional<commande> findById(Long id) {
        return commandeRepository.findById(id);
    }

    // Créer une commande
    public commande creerCommande(commande commande) {
        return commandeRepository.save(commande);
    }

    // Modifier une commande
    public commande modifierCommande(Long id, commande commande) {
        if (commandeRepository.existsById(id)) {
            commande.setId(id);
            return commandeRepository.save(commande);
        }
        throw new RuntimeException("Commande non trouvée");
    }

    // Supprimer une commande
    public void supprimerCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    // Suivre l'état de la livraison
    public Livraison suivreEtatLivraison(Long livraisonId) {
        return livraisonRepository.findById(livraisonId)
                .orElseThrow(() -> new RuntimeException("Livraison non trouvée"));
    }

    // Voir l'historique des commandes
    public List<commande> voirHistoriqueCommandes(Long clientId) {
        return commandeRepository.findByClientId(clientId);
    }
}
