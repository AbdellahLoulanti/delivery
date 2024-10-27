package com.tawssil.delivery.service;
import com.tawssil.delivery.model.Livraison;
import com.tawssil.delivery.model.commande;
import com.tawssil.delivery.model.Livreur;
import com.tawssil.delivery.repository.CommandeRepository;
import com.tawssil.delivery.repository.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private LivreurRepository livreurRepository;

    public List<commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
    public Optional<commande> findById(Long id) {
        return commandeRepository.findById(id);
    }
    public commande saveCommande(commande commande) {
        return commandeRepository.save(commande);
    }


}
