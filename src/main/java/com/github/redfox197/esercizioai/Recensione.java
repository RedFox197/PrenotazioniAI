package com.github.redfox197.esercizioai;

import java.util.ArrayList;
import java.util.List;

public class Recensione {
    public static List<Recensione> recensioni = new ArrayList<>();

    private int stelle;
    private String messaggio;
    private Prenotazione prenotazione;

    public Recensione(int stelle, String messaggio, Prenotazione prenotazione) {
        this.stelle = stelle;
        this.messaggio = messaggio;
        this.prenotazione = prenotazione;
    }

    public static void riceviRecensione(Recensione recensione) {
        recensioni.add(recensione);
    }

    public static void visualizzaRecensioni() {
        System.out.println(recensioni);
    }

    public int getStelle() {
        return stelle;
    }

    public void setStelle(int stelle) {
        this.stelle = stelle;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public Prenotazione getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Prenotazione prenotazione) {
        this.prenotazione = prenotazione;
    }

    @Override
    public String toString() {
        return "\nRecensione{" +
                "\nstelle=" + stelle +
                ", \nmessaggio='" + messaggio +
                ", \nprenotazione=" + prenotazione +
                "\n}";
    }
}
