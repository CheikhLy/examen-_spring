package examen.sn.examen_spring.web.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import examen.sn.examen_spring.web.dto.request.PaiementRequest;
import examen.sn.examen_spring.web.dto.response.PaiementResponse;

@RequestMapping("/api/paiements")
public interface PaiementController {
    
    @PostMapping
    ResponseEntity<PaiementResponse> CreatePaiement(@RequestBody PaiementRequest request);
    
    @GetMapping("/dette/{detteId}")
    List<PaiementResponse> GetPaiementDette(@PathVariable Long detteId);
    
    @GetMapping("/{id}")
    ResponseEntity<PaiementResponse> GetPaiementById(@PathVariable Long id);
}

