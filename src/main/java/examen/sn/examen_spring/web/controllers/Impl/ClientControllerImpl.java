package examen.sn.examen_spring.web.controllers.Impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import examen.sn.examen_spring.services.impl.ClientServiceImpl;
import examen.sn.examen_spring.web.controllers.ClientController;
import examen.sn.examen_spring.web.dto.request.ClientRequest;
import examen.sn.examen_spring.web.dto.response.ClientResponse;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {
    
    private final ClientServiceImpl clientService;
    
    @Override
    public ResponseEntity<ClientResponse> CreateClient(@Valid ClientRequest request) {
        ClientResponse response = clientService.Create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @Override
    public ResponseEntity<ClientResponse> GetClientById(Long id) {
        ClientResponse response = clientService.GetClientById(id);
        return ResponseEntity.ok(response);
    }
    
    @Override
    public List<ClientResponse> GetAllClient() {
        return clientService.GetAllClient();
    }
    
    @Override
    public ResponseEntity<ClientResponse> UpdateClient(Long id, @Valid ClientRequest request) {
        ClientResponse response = clientService.UpdateClient(id, request);
        return ResponseEntity.ok(response);
    }
    
    @Override
    public ResponseEntity<Void> DeleteClient(Long id) {
        clientService.DeleteClient(id);
        return ResponseEntity.noContent().build();
    }
}