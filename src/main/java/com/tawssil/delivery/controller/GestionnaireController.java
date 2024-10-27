package com.tawssil.delivery.controller;
import com.tawssil.delivery.model.Livraison;
import com.tawssil.delivery.model.Client;
import com.tawssil.delivery.model.Livreur;
import com.tawssil.delivery.model.commande;
import com.tawssil.delivery.service.GestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestionnaire")
public class GestionnaireController {

    @Autowired
    private GestionnaireService gestionnaireService;

    @GetMapping("/clients")
    public List<Client> obtenirTousLesClients() {
        return gestionnaireService.obtenirTousLesClients();
    }


    // Gestion des clients
    @PostMapping("/clients")
    public Client ajouterClient(@RequestBody Client client) {
        return gestionnaireService.ajouterClient(client);
    }

    @PutMapping("/clients/{id}")
    public Client modifierClient(@PathVariable Long id, @RequestBody Client client) {
        return gestionnaireService.modifierClient(id, client);
    }

    @DeleteMapping("/clients/{id}")
    public void supprimerClient(@PathVariable Long id) {
        gestionnaireService.supprimerClient(id);
    }

    // Création et gestion des commandes

    //afficher commandes

    @GetMapping("/commandes")
    public List<commande> obtenirTousLesLCommande() {
        return gestionnaireService.obtenirTousLesCommandes();
    }


    @PostMapping("/commandes")
    public commande creerCommande(@RequestBody commande commande) {
        return gestionnaireService.creerCommande(commande);
    }

    @PutMapping("/commandes/{id}")
    public commande modifierCommande(@PathVariable Long id, @RequestBody commande commande) {
        return gestionnaireService.modifierCommande(id, commande);
    }


    @GetMapping("/livreurs")
    public List<Livreur> obtenirTousLesLivreurs() {
        return gestionnaireService.obtenirTousLesLivreurs();
    }

    // Gestion des clients
    @PostMapping("/livreurs")
    public Livreur ajouterLivreur(@RequestBody Livreur livreur) {
        return gestionnaireService.ajouterLivreur(livreur);
    }


    @PutMapping("/livreurs/{id}")
    public Livreur modifierLivreur(@PathVariable Long id, @RequestBody Livreur livreur) {
        return gestionnaireService.modifierLivreur(id, livreur);
    }

    @DeleteMapping("/livreurs/{id}")
    public void supprimerLivreur(@PathVariable Long id) {
        gestionnaireService.supprimerLivreur(id);
    }




    // Affecter un livreur disponible
    @PutMapping("/commandes/{id}/affecter-livreur/{livreurId}")
    public commande affecterLivreur(@PathVariable Long id, @PathVariable Long livreurId) {
        return gestionnaireService.affecterLivreur(id, livreurId);
    }

    // Suivre les livraisons
    @GetMapping("/livraisons")
    public List<Livraison> suivreLivraisons() {
        return gestionnaireService.suivreLivraisons();
    }
}
