package examen.sn.examen_spring.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import examen.sn.examen_spring.data.entities.Dette;
import examen.sn.examen_spring.data.entities.Paiement;
import examen.sn.examen_spring.data.repositories.DetteRepository;
import examen.sn.examen_spring.data.repositories.PaiementRepository;
import examen.sn.examen_spring.services.PaiementService;
import examen.sn.examen_spring.utils.MapperUtil;
import examen.sn.examen_spring.web.dto.request.PaiementRequest;
import examen.sn.examen_spring.web.dto.response.PaiementResponse;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
@Transactional
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository paiementRepository;
    private final DetteRepository detteRepository;
    private final MapperUtil mapperUtil;
    
    @Override
    public PaiementResponse CreatePaiement(PaiementRequest request) {
        Dette dette = detteRepository.findById(request.getDetteId())
                .orElseThrow(() -> new RuntimeException("Dette non trouvée avec l'ID: " + request.getDetteId()));
        
        if (request.getMontant() > dette.getMontantRestant()) {
            throw new RuntimeException("Le montant du paiement ne peut pas dépasser le montant restant de la dette");
        }
        
        Paiement paiement = mapperUtil.mapToPaiement(request);
        paiement.setDette(dette);
        
        Paiement savedPaiement = paiementRepository.save(paiement);
        
        // Mettre à jour les montants de la dette
        dette.setMontantPaye(dette.getMontantPaye() + request.getMontant());
        dette.setMontantRestant(dette.getMontantDette() - dette.getMontantPaye());
        detteRepository.save(dette);
        
        return mapperUtil.mapToPaiementResponse(savedPaiement);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<PaiementResponse> GetPaiementDette(Long detteId) {
        if (!detteRepository.existsById(detteId)) {
            throw new RuntimeException("Dette non trouvée avec l'ID: " + detteId);
        }
        
        return paiementRepository.findByDetteId(detteId)
                .stream()
                .map(mapperUtil::mapToPaiementResponse)
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public PaiementResponse GetPaiementById(Long id) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé avec l'ID: " + id));
        return mapperUtil.mapToPaiementResponse(paiement);
    }
    
}
