package com.tawssil.delivery.controller;

import com.tawssil.delivery.model.Livraison;
import com.tawssil.delivery.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livreur")
public class LivreurController {

    @Autowired
    private LivreurService livreurService;

    // Gérer la disponibilité
    @PutMapping("/{id}/disponibilite")
    public void gererDisponibilite(@PathVariable Long id, @RequestBody boolean disponibilite) {
        livreurService.gererDisponibilite(id, disponibilite);
    }

    // Voir les commandes affectées
    @GetMapping("/commandes")
    public List<Livraison> voirCommandesAffectees(@RequestParam Long livreurId) {
        return livreurService.voirCommandesAffectees(livreurId);
    }

    // Mettre à jour le statut des livraisons
    @PutMapping("/livraisons/{id}")
    public Livraison mettreAJourStatutLivraison(@PathVariable Long id, @RequestBody String statut) {
        return livreurService.mettreAJourStatutLivraison(id, statut);
    }
}
