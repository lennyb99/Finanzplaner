package com.example.finanzplaner.model.finanzverwaltung;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity (tableName = "expense_table")
public class Ausgabe {

    @PrimaryKey(autoGenerate = true) @NonNull
    private int id;
    private String name;
    private float betrag;
    private String datum;
    private String ausgabekategorie;
    private boolean wiederkehrend;

    public Ausgabe(){}
    public Ausgabe(String name, float betrag, Ausgabekategorie ausgabekategorie, boolean wiederkehrend) {
        this.name = name;
        this.betrag = betrag;
        datum = Calendar.getInstance().toString();
        this.ausgabekategorie = ausgabekategorie.toString();
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

    public String getAusgabekategorie() {
        return ausgabekategorie;
    }
    public void setAusgabekategorie(String ausgabekategorie) {
        this.ausgabekategorie = ausgabekategorie;
    }

    public boolean isWiederkehrend() {
        return wiederkehrend;
    }
    public void setWiederkehrend(boolean wiederkehrend) {
        this.wiederkehrend = wiederkehrend;
    }

}
