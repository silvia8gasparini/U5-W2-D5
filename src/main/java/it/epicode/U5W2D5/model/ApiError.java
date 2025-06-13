package it.epicode.U5W2D5.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private String messaggio;
    private LocalDateTime dataErrore;
}
