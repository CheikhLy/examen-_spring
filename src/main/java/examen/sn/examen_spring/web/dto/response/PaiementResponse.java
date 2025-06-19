package examen.sn.examen_spring.web.dto.response;

import lombok.Data;

@Data
public class PaiementResponse {
    private Long id;
    private String date;
    private Double montant;
    private Long detteId;
}
