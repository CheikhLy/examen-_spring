package examen.sn.examen_spring.web.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class DetteResponse {
    private Long id;
    private String date;
    private Double montantDette;
    private Double montantPaye;
    private Double montantRestant;
    private ClientResponse client;
    private List<PaiementResponse> paiements;
}
