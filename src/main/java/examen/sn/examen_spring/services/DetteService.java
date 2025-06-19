package examen.sn.examen_spring.services;

import java.util.List;

import examen.sn.examen_spring.web.dto.request.DetteRequest;
import examen.sn.examen_spring.web.dto.response.DetteResponse;

public interface DetteService {
    DetteResponse Create(DetteRequest request);
    List<DetteResponse> GetDettesByClientId(Long clientId);
    DetteResponse GetDette(Long id);
    List<DetteResponse> GetAllDettes();
}
