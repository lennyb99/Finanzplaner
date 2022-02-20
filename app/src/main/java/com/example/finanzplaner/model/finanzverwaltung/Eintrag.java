package com.example.finanzplaner.model.finanzverwaltung;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import java.util.Calendar;

public abstract class Eintrag {

    @PrimaryKey(autoGenerate = true) @NonNull
    private int id;
    private String name;
    private float betrag;
    private Calendar datum;
    private boolean wiederkehrend;
    //private Kategorie kategorie;

    public Eintrag(String name, float betrag, boolean wiederkehrend) {
        this.name = name;
        this.betrag = betrag;
        datum = Calendar.getInstance();
        this.wiederkehrend = wiederkehrend;
        //this.kategorie = kategorie;
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

    public Calendar getDatum() {
        return datum;
    }
    public void setDatum(Calendar datum) {
        this.datum = datum;
    }

    public boolean isWiederkehrend() {
        return wiederkehrend;
    }
    public void setWiederkehrend(boolean wiederkehrend) {
        this.wiederkehrend = wiederkehrend;
    }

    /*
    public Kategorie getKategorie() {
        return kategorie;
    }
    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }
    */
}