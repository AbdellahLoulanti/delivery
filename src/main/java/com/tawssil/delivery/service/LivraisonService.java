package com.tawssil.delivery.service;

import com.tawssil.delivery.model.Livraison;
import com.tawssil.delivery.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivraisonService {

    @Autowired
    private LivraisonRepository livraisonRepository;

    public List<Livraison> findAll() {
        return livraisonRepository.findAll();
    }

    public Optional<Livraison> findById(Long id) {
        return livraisonRepository.findById(id);
    }

    public Livraison save(Livraison livraison) {
        return livraisonRepository.save(livraison);
    }

    public void deleteById(Long id) {
        livraisonRepository.deleteById(id);
    }

    public Livraison updateStatut(Long id, String statut) {
        Optional<Livraison> livraisonOpt = livraisonRepository.findById(id);
        if (livraisonOpt.isPresent()) {
            Livraison livraison = livraisonOpt.get();
            livraison.setStatut(statut);
            return livraisonRepository.save(livraison);
        }
        return null;
    }
}
