package examen.sn.examen_spring.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import examen.sn.examen_spring.data.entities.Paiement;
@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {

     List<Paiement> findByDetteId(Long detteId);
    
} 