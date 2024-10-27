package com.tawssil.delivery.controller;

import com.tawssil.delivery.model.commande;
import com.tawssil.delivery.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public List<commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @PostMapping
    public commande createCommande(@RequestBody commande commande) {
        return commandeService.saveCommande(commande);
    }
}
