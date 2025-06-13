package it.epicode.U5W2D5.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneDto {
    private LocalDate dataRichiesta;
    private String note;
    private int dipendenteId;
    private int viaggioId;
}
