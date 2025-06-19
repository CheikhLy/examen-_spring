package examen.sn.examen_spring.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Data
public class ClientRequest {
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    
    @NotBlank(message = "Le téléphone est obligatoire")
    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "Format de téléphone invalide")
    private String telephone;
    
    @NotBlank(message = "L'adresse est obligatoire")
    private String adresse;
}
