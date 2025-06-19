package examen.sn.examen_spring.utils;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import examen.sn.examen_spring.data.entities.Client;
import examen.sn.examen_spring.data.entities.Dette;
import examen.sn.examen_spring.data.entities.Paiement;
import examen.sn.examen_spring.web.dto.request.ClientRequest;
import examen.sn.examen_spring.web.dto.request.DetteRequest;
import examen.sn.examen_spring.web.dto.request.PaiementRequest;
import examen.sn.examen_spring.web.dto.response.ClientResponse;
import examen.sn.examen_spring.web.dto.response.DetteResponse;
import examen.sn.examen_spring.web.dto.response.PaiementResponse;

@Component
public class MapperUtil {
    
    // Client mappings
    public Client mapToClient(ClientRequest request) {
        Client client = new Client();
        client.setNom(request.getNom());
        client.setTelephone(request.getTelephone());
        client.setAdresse(request.getAdresse());
        return client;
    }
    
    public ClientResponse mapToClientResponse(Client client) {
        ClientResponse response = new ClientResponse();
        response.setId(client.getId());
        response.setNom(client.getNom());
        response.setTelephone(client.getTelephone());
        response.setAdresse(client.getAdresse());
        
        if (client.getDettes() != null) {
            response.setDettes(client.getDettes().stream()
                    .map(this::mapToDetteResponseWithoutClient)
                    .collect(Collectors.toList()));
        }
        
        return response;
    }
    
    // Dette mappings
    public Dette mapToDette(DetteRequest request) {
        Dette dette = new Dette();
        dette.setDate(request.getDate());
        dette.setMontantDette(request.getMontantDette());
        return dette;
    }
    
    public DetteResponse mapToDetteResponse(Dette dette) {
        DetteResponse response = new DetteResponse();
        response.setId(dette.getId());
        response.setDate(dette.getDate());
        response.setMontantDette(dette.getMontantDette());
        response.setMontantPaye(dette.getMontantPaye());
        response.setMontantRestant(dette.getMontantRestant());
        
        if (dette.getClient() != null) {
            response.setClient(mapToClientResponseWithoutDettes(dette.getClient()));
        }
        
        if (dette.getPaiements() != null) {
            response.setPaiements(dette.getPaiements().stream()
                    .map(this::mapToPaiementResponse)
                    .collect(Collectors.toList()));
        }
        
        return response;
    }
    
    private DetteResponse mapToDetteResponseWithoutClient(Dette dette) {
        DetteResponse response = new DetteResponse();
        response.setId(dette.getId());
        response.setDate(dette.getDate());
        response.setMontantDette(dette.getMontantDette());
        response.setMontantPaye(dette.getMontantPaye());
        response.setMontantRestant(dette.getMontantRestant());
        return response;
    }
    
    private ClientResponse mapToClientResponseWithoutDettes(Client client) {
        ClientResponse response = new ClientResponse();
        response.setId(client.getId());
        response.setNom(client.getNom());
        response.setTelephone(client.getTelephone());
        response.setAdresse(client.getAdresse());
        return response;
    }
    
    // Paiement mappings
    public Paiement mapToPaiement(PaiementRequest request) {
        Paiement paiement = new Paiement();
        paiement.setDate(request.getDate());
        paiement.setMontant(request.getMontant());
        return paiement;
    }
    
    public PaiementResponse mapToPaiementResponse(Paiement paiement) {
        PaiementResponse response = new PaiementResponse();
        response.setId(paiement.getId());
        response.setDate(paiement.getDate());
        response.setMontant(paiement.getMontant());
        response.setDetteId(paiement.getDette().getId());
        return response;
    }
}
