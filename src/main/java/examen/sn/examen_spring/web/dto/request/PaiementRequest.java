package examen.sn.examen_spring.web.dto.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class PaiementRequest {
    @NotBlank(message = "La date est obligatoire")
    private String date;
    
    @NotNull(message = "Le montant est obligatoire")
    @Positive(message = "Le montant doit être positif")
    private Double montant;
    
    @NotNull(message = "L'ID de la dette est obligatoire")
    private Long detteId;
}
