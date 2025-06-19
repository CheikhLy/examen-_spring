package examen.sn.examen_spring.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import examen.sn.examen_spring.data.entities.Client;
import examen.sn.examen_spring.data.entities.Dette;
import examen.sn.examen_spring.data.repositories.ClientRepository;
import examen.sn.examen_spring.data.repositories.DetteRepository;
import examen.sn.examen_spring.services.DetteService;
import examen.sn.examen_spring.utils.MapperUtil;
import examen.sn.examen_spring.web.dto.request.DetteRequest;
import examen.sn.examen_spring.web.dto.response.DetteResponse;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
@Transactional
public class DetteServiceImpl implements DetteService {

  
    private final DetteRepository detteRepository;
    private final ClientRepository clientRepository;
    private final MapperUtil mapperUtil;
    
    @Override
    public DetteResponse Create(DetteRequest request) {
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID: " + request.getClientId()));
        
        Dette dette = mapperUtil.mapToDette(request);
        dette.setClient(client);
        dette.setMontantPaye(0.0);
        dette.setMontantRestant(request.getMontantDette());
        
        Dette savedDette = detteRepository.save(dette);
        return mapperUtil.mapToDetteResponse(savedDette);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<DetteResponse> GetDettesByClientId(Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new RuntimeException("Client non trouvé avec l'ID: " + clientId);
        }
        
        return detteRepository.findByClientId(clientId)
                .stream()
                .map(mapperUtil::mapToDetteResponse)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public DetteResponse GetDette(Long id) {
        Dette dette = detteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dette non trouvée avec l'ID: " + id));
        return mapperUtil.mapToDetteResponse(dette);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<DetteResponse> GetAllDettes() {
        return detteRepository.findAll()
                .stream()
                .map(mapperUtil::mapToDetteResponse)
                .collect(Collectors.toList());
    }
   
}
