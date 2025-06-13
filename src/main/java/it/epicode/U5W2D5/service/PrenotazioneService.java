package it.epicode.U5W2D5.service;

import it.epicode.U5W2D5.dto.PrenotazioneDto;
import it.epicode.U5W2D5.exception.NotFoundException;
import it.epicode.U5W2D5.exception.ValidationException;
import it.epicode.U5W2D5.model.Dipendente;
import it.epicode.U5W2D5.model.Prenotazione;
import it.epicode.U5W2D5.model.Viaggio;
import it.epicode.U5W2D5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private ViaggioService viaggioService;

    public Prenotazione savePrenotazione(PrenotazioneDto prenotazioneDto) {
        Dipendente dipendente = dipendenteService.getDipendente(prenotazioneDto.getDipendenteId());
        Viaggio viaggio = viaggioService.getViaggio(prenotazioneDto.getViaggioId());

        boolean esisteConflitto = prenotazioneRepository
                .existsByDipendente_IdAndDataRichiesta(prenotazioneDto.getDipendenteId(), prenotazioneDto.getDataRichiesta());

        if (esisteConflitto) {
            throw new ValidationException("Il dipendente ha già una prenotazione per questa data.");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRichiesta(prenotazioneDto.getDataRichiesta());
        prenotazione.setNote(prenotazioneDto.getNote());

        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public void deletePrenotazione(int id) {
        Prenotazione prenotazioneDaCancellare = prenotazioneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prenotazione con id " + id + " non trovata"));
        prenotazioneRepository.delete(prenotazioneDaCancellare);
    }
}
