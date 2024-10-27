package com.tawssil.delivery.service;

import com.tawssil.delivery.model.Gestionnaire;
import com.tawssil.delivery.model.Utilisateur;
import com.tawssil.delivery.model.commande;
import com.tawssil.delivery.model.Livraison;
import com.tawssil.delivery.repository.GestionnaireRepository;
import com.tawssil.delivery.repository.UtilisateurRepository;
import com.tawssil.delivery.repository.CommandeRepository;
import com.tawssil.delivery.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private GestionnaireRepository gestionnaireRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private LivraisonRepository livraisonRepository;

    //afficher tous les gestionnaires
    public List<Gestionnaire> obtenirTousLesGestionnaires() {
        return gestionnaireRepository.findAll();
    }

    // Ajouter un gestionnaire
    public Gestionnaire ajouterGestionnaire(Gestionnaire gestionnaire) {
        return gestionnaireRepository.save(gestionnaire);
    }

    // Modifier un gestionnaire
    public Gestionnaire modifierGestionnaire(Long id, Gestionnaire gestionnaire) {
        if (gestionnaireRepository.existsById(id)) {
            gestionnaire.setId(id);
            return gestionnaireRepository.save(gestionnaire);
        }
        throw new RuntimeException("Gestionnaire non trouvé");
    }

    // Supprimer un gestionnaire
    public void supprimerGestionnaire(Long id) {
        gestionnaireRepository.deleteById(id);
    }

    // Obtenir tous les utilisateurs (clients, livreurs)
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Voir toutes les commandes
    public List<commande> voirCommandes() {
        return commandeRepository.findAll();
    }

    // Voir toutes les livraisons
    public List<Livraison> voirLivraisons() {
        return livraisonRepository.findAll();
    }
}
