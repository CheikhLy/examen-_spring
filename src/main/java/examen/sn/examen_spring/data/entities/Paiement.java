package examen.sn.examen_spring.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paiements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String date;
    
    @Column(nullable = false)
    private Double montant;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dette_id", nullable = false)
    private Dette dette;
}
