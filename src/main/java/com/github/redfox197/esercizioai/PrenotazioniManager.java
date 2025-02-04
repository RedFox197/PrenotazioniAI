package com.github.redfox197.esercizioai;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;

import java.util.ArrayList;
import java.util.List;

public class PrenotazioniManager {
    private List<Prenotazione> prenotazioni = new ArrayList<>();

    @Tool("salva una prenotazione fornita in ingresso arg0. Si è pregati di utilizzare questo formato per la prenotazione in ingresso: {\"soggiorno\":true,\"nominativo\":\"Luigi Matrone\",\"checkOut\":{\"month\":9.0,\"day\":23.0,\"year\":2025.0},\"checkIn\":{\"month\":9.0,\"day\":20.0,\"year\":2025.0},\"estremiDocumento\":\"ca20le\",\"nrPersone\":4.0,\"telefono\":\"303 202 30 10\"}")
    public void salvaPrenotazione(@P("rispetta questo formato: {\"soggiorno\":true,\"nominativo\":\"Luigi Matrone\",\"checkOut\":{\"month\":9.0,\"day\":23.0,\"year\":2025.0},\"checkIn\":{\"month\":9.0,\"day\":20.0,\"year\":2025.0},\"estremiDocumento\":\"ca20le\",\"nrPersone\":4.0,\"telefono\":\"303 202 30 10\"}") Prenotazione prenotazione) {
        prenotazioni.add(prenotazione);
    }

    @Tool("annulla prenotazione")
    public boolean annullaPrenotazione(@P(value = "estremo documento") String documento) {
        for (Prenotazione prenotazione : prenotazioni) {
            if (prenotazione.getEstremiDocumento().equalsIgnoreCase(documento)) {
                prenotazioni.remove(prenotazione);
                return true;
            }
        }
        return false;
    }

    @Tool("ottieni una lista di prenotazioni salvate da inviare all'utente")
    public List<Prenotazione> ottieniPrenotazioniSalvate() {
        return prenotazioni;
    }
}
