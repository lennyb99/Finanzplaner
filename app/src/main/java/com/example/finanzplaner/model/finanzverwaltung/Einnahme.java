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
    private float betrag;
    private String datum;
    private String einnahmekategorie;
    private boolean wiederkehrend;

    public Einnahme(){}
    public Einnahme(String name, float betrag, Einnahmekategorie einnahmekategorie, boolean wiederkehrend) {
        this.name = name;
        this.betrag = betrag;
        datum = Calendar.getInstance().toString();
        this.einnahmekategorie = einnahmekategorie.toString();
        this.wiederkehrend = wiederkehrend;
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

    public String getEinnahmekategorie() {
        return einnahmekategorie;
    }
    public void setEinnahmekategorie(String einnahmekategorie) {
        this.einnahmekategorie = einnahmekategorie;
    }

    public boolean isWiederkehrend() {
        return wiederkehrend;
    }
    public void setWiederkehrend(boolean wiederkehrend) {
        this.wiederkehrend = wiederkehrend;
    }

}