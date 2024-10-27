package com.tawssil.delivery.service;

import com.tawssil.delivery.model.*;
import com.tawssil.delivery.repository.ClientRepository;
import com.tawssil.delivery.repository.CommandeRepository;
import com.tawssil.delivery.repository.LivraisonRepository;
import com.tawssil.delivery.repository.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service de gestion pour les opérations sur les clients, livreurs, commandes et livraisons.
 */
@Service
public class GestionnaireService {

    // Déclaration des repositories nécessaires
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private LivreurRepository livreurRepository;
    @Autowired
    private LivraisonRepository livraisonRepository;



    // ***********************************
    // Gestion des Clients
    // ***********************************


    //afficher clients

    public List<Client> obtenirTousLesClients() {
        return clientRepository.findAll();
    }

    //ajouter client

    public Client ajouterClient(Client client) {
        return clientRepository.save(client);
    }

   //modifier client

    public Client modifierClient(Long id, Client client) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            return clientRepository.save(client);
        }
        throw new RuntimeException("Client non trouvé");
    }

    //supprimer client

    public void supprimerClient(Long id) {
        clientRepository.deleteById(id);
    }

    // ***********************************
    // Gestion des Livreurs
    // ***********************************



    // ajouter livreurs

    public Livreur ajouterLivreur(Livreur livreur) {
        return livreurRepository.save(livreur);
    }

    //afficher livreurs

    public List<Livreur> obtenirTousLesLivreurs() {
        return livreurRepository.findAll();
    }

   //modifer livreur

    public Livreur modifierLivreur(Long id, Livreur livreur) {
        if (livreurRepository.existsById(id)) {
            livreur.setId(id);
            return livreurRepository.save(livreur);
        }
        throw new RuntimeException("Livreur non trouvé");
    }

   //supprimer livreurs

    public void supprimerLivreur(Long id) {
        livreurRepository.deleteById(id);
    }



    // ***********************************
    // Gestion des Commandes
    // ***********************************



    //ajouter commande

    public commande creerCommande(commande commande) {
        return commandeRepository.save(commande);
    }

    //afficher commande

    public List<commande> obtenirTousLesCommandes() {
        return commandeRepository.findAll();
    }

   //modifier

    public commande modifierCommande(Long id, commande commande) {
        if (commandeRepository.existsById(id)) {
            commande.setId(id);
            return commandeRepository.save(commande);
        }
        throw new RuntimeException("Commande non trouvée");
    }

   //affecter commande a livreur

    public commande affecterLivreur(Long commandeId, Long livreurId) {
        commande commande = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));
        Livreur livreur = livreurRepository.findById(livreurId)
                .orElseThrow(() -> new RuntimeException("Livreur non trouvé"));
        commande.setLivreur(livreur);
        return commandeRepository.save(commande);
    }

    // ***********************************
    // Gestion des Livraisons
    // ***********************************



    //suivre livraisons

    public List<Livraison> suivreLivraisons() {
        return livraisonRepository.findAll();
    }
}
