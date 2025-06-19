package examen.sn.examen_spring.services;

import java.util.List;

import examen.sn.examen_spring.web.dto.request.PaiementRequest;
import examen.sn.examen_spring.web.dto.response.PaiementResponse;

public interface PaiementService {
    PaiementResponse CreatePaiement(PaiementRequest request);
    List<PaiementResponse> GetPaiementDette(Long detteId);
    PaiementResponse GetPaiementById(Long id);
}
