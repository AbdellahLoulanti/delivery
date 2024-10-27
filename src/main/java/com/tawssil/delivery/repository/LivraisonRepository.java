package com.tawssil.delivery.repository;

import com.tawssil.delivery.model.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
    List<Livraison> findByLivreurId(Long livreurId); // Pour récupérer les livraisons affectées à un livreur spécifique
}
