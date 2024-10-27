package com.tawssil.delivery.controller;

import com.tawssil.delivery.model.Livraison;
import com.tawssil.delivery.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livraisons")
public class LivraisonController {

    @Autowired
    private LivraisonService livraisonService;

    @GetMapping
    public List<Livraison> getAllLivraisons() {
        return livraisonService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livraison> getLivraisonById(@PathVariable Long id) {
        Optional<Livraison> livraison = livraisonService.findById(id);
        return livraison.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Livraison createLivraison(@RequestBody Livraison livraison) {
        return livraisonService.save(livraison);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livraison> updateLivraison(@PathVariable Long id, @RequestBody Livraison updatedLivraison) {
        Optional<Livraison> livraisonOpt = livraisonService.findById(id);
        if (livraisonOpt.isPresent()) {
            updatedLivraison.setId(id);
            return ResponseEntity.ok(livraisonService.save(updatedLivraison));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/statut")
    public ResponseEntity<Livraison> updateLivraisonStatut(@PathVariable Long id, @RequestBody String statut) {
        Livraison updatedLivraison = livraisonService.updateStatut(id, statut);
        if (updatedLivraison != null) {
            return ResponseEntity.ok(updatedLivraison);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivraison(@PathVariable Long id) {
        if (livraisonService.findById(id).isPresent()) {
            livraisonService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
