package examen.sn.examen_spring.web.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class DetteRequest {
    @NotBlank(message = "La date est obligatoire")
    private String date;
    
    @NotNull(message = "Le montant de la dette est obligatoire")
    @Positive(message = "Le montant doit être positif")
    private Double montantDette;
    
    @NotNull(message = "L'ID du client est obligatoire")
    private Long clientId;
}

