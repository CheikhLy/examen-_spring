package examen.sn.examen_spring.web.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import examen.sn.examen_spring.web.dto.request.ClientRequest;
import examen.sn.examen_spring.web.dto.response.ClientResponse;

@RequestMapping("/api/clients")
public interface ClientController {
    
    @PostMapping
    ResponseEntity<ClientResponse> CreateClient(@RequestBody ClientRequest request);
    
    @GetMapping("/{id}")
    ResponseEntity<ClientResponse> GetClientById(@PathVariable Long id);
    

    
    @PutMapping("/{id}")
    ResponseEntity<ClientResponse> UpdateClient(@PathVariable Long id, @RequestBody ClientRequest request);
    
    @DeleteMapping("/{id}")
    ResponseEntity<Void> DeleteClient(@PathVariable Long id);

    
    @GetMapping
    List<ClientResponse> GetAllClient();
    
  
}
