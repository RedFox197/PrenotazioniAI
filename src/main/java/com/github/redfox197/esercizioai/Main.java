package com.github.redfox197.esercizioai;

import com.github.redfox197.esercizioai.ai.service.AssistantPrenotazioni;
import com.github.redfox197.esercizioai.ai.service.Recensore;
import com.google.gson.JsonSyntaxException;
import dev.langchain4j.data.message.ToolExecutionResultMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.Result;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GoogleAiGeminiChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("API_KEY"))
                .modelName("gemini-2.0-flash-exp")
                .temperature(0.0)
                .build();

        PrenotazioniManager prenotazioniManager = new PrenotazioniManager();
        AssistantPrenotazioni bot = AiServices.builder(AssistantPrenotazioni.class)
                .chatLanguageModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(200))
                .tools(prenotazioniManager)
                .build();

        Recensore recensore = AiServices.builder(Recensore.class)
                .chatLanguageModel(model)
                .build();

        while (true) {
            System.out.println("Tu: ");
            String text = scanner.nextLine();
            if (text.equalsIgnoreCase("!exit")) break;

            Result<String> response;
            try {
                response = bot.chat(UserMessage.from(text));
            } catch (JsonSyntaxException e) {
                response = bot.chat(ToolExecutionResultMessage.toolExecutionResultMessage(null, "salvaPrenotazione", "l'assistente richiami il metodo reinserendo i dati con il formato corretto!"));
            }
            System.out.println("Assistente");
            System.out.println(response.content());
        }

        for (Prenotazione prenotazione : prenotazioniManager.ottieniPrenotazioniSalvate()) {
            Recensione.riceviRecensione(recensore.lasciaRecensione(prenotazione));
        }

        Recensione.visualizzaRecensioni();

        // FIXME - Le prenotazioni che passano alla recensione sono ricreate da 0 con gli stessi valori
        for (Recensione recensione : Recensione.recensioni) {
            for (Prenotazione prenotazione : prenotazioniManager.ottieniPrenotazioniSalvate()) {
                if (prenotazione == recensione.getPrenotazione()) {
                    System.out.println("UGUALE");
                }
            }
        }
        scanner.close();
    }
}
