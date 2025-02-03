package com.github.redfox197.esercizioai;

import dev.langchain4j.model.output.structured.Description;

import java.time.LocalDate;

@Description(value = "Prenotazione B&B da matrone")
public class Prenotazione {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int nrPersone;
    private String nominativo;
    private String telefono;
    private String estremiDocumento;
    private boolean soggiorno;

    public Prenotazione(LocalDate checkIn, LocalDate checkOut, int nrPersone, String nominativo, String telefono, String estremiDocumento, boolean soggiorno) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.nrPersone = nrPersone;
        this.nominativo = nominativo;
        this.telefono = telefono;
        this.estremiDocumento = estremiDocumento;
        this.soggiorno = soggiorno;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public int getNrPersone() {
        return nrPersone;
    }

    public void setNrPersone(int nrPersone) {
        this.nrPersone = nrPersone;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstremiDocumento() {
        return estremiDocumento;
    }

    public void setEstremiDocumento(String estremiDocumento) {
        this.estremiDocumento = estremiDocumento;
    }

    public boolean isSoggiorno() {
        return soggiorno;
    }

    public void setSoggiorno(boolean soggiorno) {
        this.soggiorno = soggiorno;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", nrPersone=" + nrPersone +
                ", nominativo='" + nominativo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", estremiDocumento='" + estremiDocumento + '\'' +
                ", soggiorno=" + soggiorno +
                '}';
    }
}
