package it.epicode.U5W2D5.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DipendenteDto {
    @NotEmpty(message = "Username obbligatorio")
    private String username;
    @NotEmpty(message = "Nome obbligatorio")
    private String nome;
    @NotEmpty(message = "Cognome obbligatorio")
    private String cognome;
    @NotEmpty(message = "Email obbligatoria")
    private String email;
    private String avatar;
}
