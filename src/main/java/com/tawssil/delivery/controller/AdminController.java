package com.tawssil.delivery.controller;

import com.tawssil.delivery.model.*;
import com.tawssil.delivery.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    public String sayHello(){ return "hello abdos test"  ; }


    @Autowired
    private AdminService adminService;

    // Gestion des gestionnaires

    @GetMapping("/gestionnaires")
    public List<Gestionnaire> obtenirTousLesGestionnaires() {
        return adminService.obtenirTousLesGestionnaires();
    }

    @PostMapping("/gestionnaires")
    public Gestionnaire ajouterGestionnaire(@RequestBody Gestionnaire gestionnaire) {
        return adminService.ajouterGestionnaire(gestionnaire);
    }

    @PutMapping("/gestionnaires/{id}")
    public Gestionnaire modifierGestionnaire(@PathVariable Long id, @RequestBody Gestionnaire gestionnaire) {
        return adminService.modifierGestionnaire(id, gestionnaire);
    }

    @DeleteMapping("/gestionnaires/{id}")
    public void supprimerGestionnaire(@PathVariable Long id) {
        adminService.supprimerGestionnaire(id);
    }

    // Supervision des utilisateurs (clients, livreurs)
    @GetMapping("/utilisateurs")
    public List<Utilisateur> getAllUtilisateurs() {
        return adminService.getAllUtilisateurs();
    }

    // Voir les commandes et les livraisons
    @GetMapping("/commandes")
    public List<commande> voirCommandes() {
        return adminService.voirCommandes();
    }

    @GetMapping("/livraisons")
    public List<Livraison> voirLivraisons() {
        return adminService.voirLivraisons();
    }
}
