package examen.sn.examen_spring.web.controllers.Impl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import examen.sn.examen_spring.services.impl.PaiementServiceImpl;
import examen.sn.examen_spring.web.controllers.PaiementController;
import examen.sn.examen_spring.web.dto.request.PaiementRequest;
import examen.sn.examen_spring.web.dto.response.PaiementResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PaiementControllerImpl implements PaiementController {
    
    private final PaiementServiceImpl paiementService;
    
    
    @Override
    public ResponseEntity<PaiementResponse> CreatePaiement(@Valid PaiementRequest request) {
        PaiementResponse response = paiementService.CreatePaiement(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @Override
    public List<PaiementResponse> GetPaiementDette(Long detteId) {
        return paiementService.GetPaiementDette(detteId);
    }
    
    @Override
    public ResponseEntity<PaiementResponse> GetPaiementById(Long id) {
        PaiementResponse response = paiementService.GetPaiementById(id);
        return ResponseEntity.ok(response);
    }
}

