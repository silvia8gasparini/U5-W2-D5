package it.epicode.U5W2D5.model;

import it.epicode.U5W2D5.enumeration.StatoViaggio;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Viaggio {
    @Id
    @GeneratedValue
    private int id;
    private String destinazione;
    private LocalDate dataViaggio;
    @Enumerated
    private StatoViaggio statoViaggio;
}
