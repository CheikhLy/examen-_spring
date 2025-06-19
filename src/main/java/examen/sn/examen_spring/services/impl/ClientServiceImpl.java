package examen.sn.examen_spring.services.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import examen.sn.examen_spring.data.entities.Client;
import examen.sn.examen_spring.data.repositories.ClientRepository;
import examen.sn.examen_spring.services.ClientService;
import examen.sn.examen_spring.utils.MapperUtil;
import examen.sn.examen_spring.web.dto.request.ClientRequest;
import examen.sn.examen_spring.web.dto.response.ClientResponse;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final MapperUtil mapperUtil;
    
    @Override
    public ClientResponse Create(ClientRequest request) {
        if (clientRepository.existsByTelephone(request.getTelephone())) {
            throw new RuntimeException("Un client avec ce numéro de téléphone existe déjà");
        }
        
        Client client = mapperUtil.mapToClient(request);
        Client savedClient = clientRepository.save(client);
        return mapperUtil.mapToClientResponse(savedClient);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ClientResponse GetClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID: " + id));
        return mapperUtil.mapToClientResponse(client);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<ClientResponse> GetAllClient() {
        return clientRepository.findAll()
                .stream()
                .map(mapperUtil::mapToClientResponse)
                .collect(Collectors.toList());
    }
    
    @Override
    public ClientResponse UpdateClient(Long id, ClientRequest request) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID: " + id));
        
        if (!client.getTelephone().equals(request.getTelephone()) 
            && clientRepository.existsByTelephone(request.getTelephone())) {
            throw new RuntimeException("Un client avec ce numéro de téléphone existe déjà");
        }
        
        client.setNom(request.getNom());
        client.setTelephone(request.getTelephone());
        client.setAdresse(request.getAdresse());
        
        Client savedClient = clientRepository.save(client);
        return mapperUtil.mapToClientResponse(savedClient);
    }
    
    @Override
    public void DeleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client non trouvé avec l'ID: " + id);
        }
        clientRepository.deleteById(id);
    }
    
}
