package examen.sn.examen_spring.web.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import examen.sn.examen_spring.web.dto.request.DetteRequest;
import examen.sn.examen_spring.web.dto.response.DetteResponse;

@RequestMapping("/api/dettes")
public interface DetteController {
    
    @PostMapping
    ResponseEntity<DetteResponse> Create(@RequestBody DetteRequest request);
    
   
    
    @GetMapping("/{id}")
    ResponseEntity<DetteResponse> GetDette(@PathVariable Long id);
    
   

    
    @GetMapping("/client/{clientId}")
    List<DetteResponse> GetDettesByClientId(@PathVariable Long clientId);
    
   
    
    @GetMapping
    List<DetteResponse> GetAllDettes();
}
