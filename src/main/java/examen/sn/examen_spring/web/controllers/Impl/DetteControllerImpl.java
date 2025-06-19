package examen.sn.examen_spring.web.controllers.Impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import examen.sn.examen_spring.services.DetteService;
import examen.sn.examen_spring.services.impl.DetteServiceImpl;
import examen.sn.examen_spring.web.controllers.DetteController;
import examen.sn.examen_spring.web.dto.request.DetteRequest;
import examen.sn.examen_spring.web.dto.response.DetteResponse;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
public class DetteControllerImpl implements DetteController {
    
    private final DetteService detteService;
    
    @Override
    public ResponseEntity<DetteResponse> Create(@Valid DetteRequest request) {
        DetteResponse response = detteService.Create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @Override
    public List<DetteResponse> GetDettesByClientId(Long clientId) {
        return detteService.GetDettesByClientId(clientId);
    }
    
    @Override
    public ResponseEntity<DetteResponse> GetDette(Long id) {
        DetteResponse response = detteService.GetDette(id);
        return ResponseEntity.ok(response);
    }
    
    @Override
    public List<DetteResponse> GetAllDettes() {
        return detteService.GetAllDettes();
    }
    
}    

