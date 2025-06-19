package examen.sn.examen_spring.services;

import java.util.List;

import examen.sn.examen_spring.web.dto.request.ClientRequest;
import examen.sn.examen_spring.web.dto.response.ClientResponse;

public interface ClientService {
    ClientResponse Create(ClientRequest request);
    ClientResponse GetClientById(Long id);
    List<ClientResponse> GetAllClient();
    ClientResponse UpdateClient(Long id, ClientRequest request);
    void DeleteClient(Long id);
}
