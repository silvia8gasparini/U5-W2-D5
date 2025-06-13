package it.epicode.U5W2D5.dto;

import it.epicode.U5W2D5.enumeration.StatoViaggio;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViaggioDto {
    private String destinazione;
    private LocalDate dataViaggio;
    private StatoViaggio statoViaggio;
}
