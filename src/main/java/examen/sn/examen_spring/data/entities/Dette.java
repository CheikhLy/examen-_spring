package examen.sn.examen_spring.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "dettes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String date;
    
    @Column(nullable = false)
    private Double montantDette;
    
    @Column(nullable = false)
    private Double montantPaye = 0.0;
    
    @Column(nullable = false)
    private Double montantRestant;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    
    @OneToMany(mappedBy = "dette", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Paiement> paiements;
    
    @PrePersist
    @PreUpdate
    private void calculerMontants() {
        if (paiements != null) {
            montantPaye = paiements.stream()
                    .mapToDouble(Paiement::getMontant)
                    .sum();
        }
        montantRestant = montantDette - montantPaye;
    }
}

