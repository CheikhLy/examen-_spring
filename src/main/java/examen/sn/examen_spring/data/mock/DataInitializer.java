package examen.sn.examen_spring.data.mock;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import examen.sn.examen_spring.data.entities.Client;
import examen.sn.examen_spring.data.entities.Dette;
import examen.sn.examen_spring.data.entities.Paiement;
import examen.sn.examen_spring.data.repositories.ClientRepository;
import examen.sn.examen_spring.data.repositories.DetteRepository;
import examen.sn.examen_spring.data.repositories.PaiementRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    
    private final ClientRepository clientRepository;
    private final DetteRepository detteRepository;
    private final PaiementRepository paiementRepository;
    
    @Override
    public void run(String... args) throws Exception {
        if (clientRepository.count() == 0) {
            initializeData();
        }
    }
    
    private void initializeData() {
        // Créer des clients
        Client client1 = new Client();
        client1.setNom("Amadou Diallo");
        client1.setTelephone("+221771234567");
        client1.setAdresse("Parcelles Assainies, Dakar");
        
        Client client2 = new Client();
        client2.setNom("Fatou Sall");
        client2.setTelephone("+221775678901");
        client2.setAdresse("Médina, Dakar");
        
        Client client3 = new Client();
        client3.setNom("Ousmane Ba");
        client3.setTelephone("+221789012345");
        client3.setAdresse("Yoff, Dakar");
        
        clientRepository.saveAll(Arrays.asList(client1, client2, client3));
        
        // Créer des dettes
        Dette dette1 = new Dette();
        dette1.setDate(LocalDate.now().minusDays(30).toString());
        dette1.setMontantDette(150000.0);
        dette1.setMontantPaye(50000.0);
        dette1.setMontantRestant(100000.0);
        dette1.setClient(client1);
        
        Dette dette2 = new Dette();
        dette2.setDate(LocalDate.now().minusDays(15).toString());
        dette2.setMontantDette(200000.0);
        dette2.setMontantPaye(0.0);
        dette2.setMontantRestant(200000.0);
        dette2.setClient(client1);
        
        Dette dette3 = new Dette();
        dette3.setDate(LocalDate.now().minusDays(10).toString());
        dette3.setMontantDette(75000.0);
        dette3.setMontantPaye(25000.0);
        dette3.setMontantRestant(50000.0);
        dette3.setClient(client2);
        
        detteRepository.saveAll(Arrays.asList(dette1, dette2, dette3));
        
        // Créer des paiements
        Paiement paiement1 = new Paiement();
        paiement1.setDate(LocalDate.now().minusDays(25).toString());
        paiement1.setMontant(30000.0);
        paiement1.setDette(dette1);
        
        Paiement paiement2 = new Paiement();
        paiement2.setDate(LocalDate.now().minusDays(20).toString());
        paiement2.setMontant(20000.0);
        paiement2.setDette(dette1);
        
        Paiement paiement3 = new Paiement();
        paiement3.setDate(LocalDate.now().minusDays(5).toString());
        paiement3.setMontant(25000.0);
        paiement3.setDette(dette3);
        
        paiementRepository.saveAll(Arrays.asList(paiement1, paiement2, paiement3));
        
        System.out.println("Données de test initialisées avec succès !");
    }
}
