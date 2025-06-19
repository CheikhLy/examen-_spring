package examen.sn.examen_spring.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import examen.sn.examen_spring.data.entities.Dette;
@Repository
public interface DetteRepository extends JpaRepository<Dette, Long> {
       List<Dette> findByClientId(Long clientId);
    
    // @Query("SELECT d FROM Dette d WHERE d.client.id = :clientId AND d.montantRestant > 0")
    List<Dette> findDettesActivesByClientId(@Param("clientId") Long clientId);
}
