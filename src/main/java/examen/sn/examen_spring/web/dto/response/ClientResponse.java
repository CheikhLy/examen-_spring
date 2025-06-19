package examen.sn.examen_spring.web.dto.response;
import java.util.List;

import lombok.Data;

@Data
public class ClientResponse {
    private Long id;
    private String nom;
    private String telephone;
    private String adresse;
    private List<DetteResponse> dettes;
}
