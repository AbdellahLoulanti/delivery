package com.tawssil.delivery.controller;
import com.tawssil.delivery.model.Client;
import com.tawssil.delivery.model.commande;

import com.tawssil.delivery.model.Livraison;
import com.tawssil.delivery.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    //afficher commande
    @GetMapping("/commandes")
    public List<commande> obtenirTousLesCommandes() {
        return clientService.obtenirTousLesCommandes();
    }
    @GetMapping("commandes/{id}")
    public ResponseEntity<commande> getLivraisonById(@PathVariable Long id) {
        Optional<commande> commande = clientService.findById(id);
        return commande.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Créer une commande
    @PostMapping("/commandes")
    public commande creerCommande(@RequestBody commande commande) {
        return clientService.creerCommande(commande);
    }

    // Modifier une commande
    @PutMapping("/commandes/{id}")
    public commande modifierCommande(@PathVariable Long id, @RequestBody commande commande) {
        return clientService.modifierCommande(id, commande);
    }

    // Supprimer une commande
    @DeleteMapping("/commandes/{id}")
    public void supprimerCommande(@PathVariable Long id) {
        clientService.supprimerCommande(id);
    }

    // Suivre l'état de la livraison
    @GetMapping("/livraisons/{id}")
    public Livraison suivreEtatLivraison(@PathVariable Long id) {
        return clientService.suivreEtatLivraison(id);
    }

    // Voir l'historique des commandes
    @GetMapping("/commandes/historique")
    public List<commande> voirHistoriqueCommandes(@RequestParam Long clientId) {
        return clientService.voirHistoriqueCommandes(clientId);
    }
}
