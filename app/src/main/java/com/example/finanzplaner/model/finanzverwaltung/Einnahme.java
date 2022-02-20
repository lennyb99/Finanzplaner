package com.example.finanzplaner.model.finanzverwaltung;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity (tableName = "income_table")
public class Einnahme {

    @PrimaryKey(autoGenerate = true) @NonNull
    private int id;
    private String name;
    //private float betrag;
    private String datum;
    private boolean wiederkehrend;
    private String einnahmekategorie;

    public Einnahme(){}
    public Einnahme(String name, float betrag, boolean wiederkehrend, Einnahmekategorie einnahmekategorie) {
        this.name = name;
        this.betrag = betrag;
        this.wiederkehrend = wiederkehrend;
        datum = Calendar.getInstance().toString();
        this.einnahmekategorie = einnahmekategorie.toString();
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

    public String getDatum() {
        return datum;
    }
    public void setDatum(String datum) {
        this.datum = datum;
    }

    public boolean isWiederkehrend() {
        return wiederkehrend;
    }
    public void setWiederkehrend(boolean wiederkehrend) {
        this.wiederkehrend = wiederkehrend;
    }

    public String getEinnahmekategorie() {
        return einnahmekategorie;
    }
    public void setEinnahmekategorie(String einnahmekategorie) {
        this.einnahmekategorie = einnahmekategorie;
    }

}