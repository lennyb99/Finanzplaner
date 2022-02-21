package com.example.finanzplaner.model.finanzverwaltung;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Eintrag {

    @PrimaryKey(autoGenerate = true) @NonNull
    private int id;
    private String name;
    private float betrag;
    private LocalDate datum;
    private boolean wiederkehrend;

    public Eintrag(String name, float betrag, boolean wiederkehrend) {
        this.name = name;
        this.betrag = betrag;
        datum = LocalDate.now();
        this.wiederkehrend = wiederkehrend;
    }

    @Override
    public String toString() {
        return "Eintrag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", betrag=" + betrag +
                ", datum=" + datum +
                ", wiederkehrend=" + wiederkehrend +
                '}';
    }

    public String getFormattedDatum() {
        String formattedDate = datum.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDate;
    }

    public String getFormattedDatum(LocalDate ld) {
        String formattedDate = ld.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return formattedDate;
    }

    //Getter und Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getBetrag() {
        return betrag;
    }
    public void setBetrag(float betrag) {
        this.betrag = betrag;
    }

    public LocalDate getDatum() {
        return datum;
    }
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public boolean isWiederkehrend() {
        return wiederkehrend;
    }
    public void setWiederkehrend(boolean wiederkehrend) {
        this.wiederkehrend = wiederkehrend;
    }

}