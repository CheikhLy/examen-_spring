package examen.sn.examen_spring.data.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import examen.sn.examen_spring.data.entities.Client;
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByTelephone(String telephone);
    boolean existsByTelephone(String telephone);
} 