package com.github.redfox197.esercizioai.ai.service;

import com.github.redfox197.esercizioai.Prenotazione;
import com.github.redfox197.esercizioai.Recensione;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface Recensore {
    @SystemMessage("Sei colui che ha prenotato in un B&B da Matrone")
    @UserMessage("lascia una recensione per: {{prenotazione}}")
    Recensione lasciaRecensione(@V("prenotazione") Prenotazione prenotazione);
}
