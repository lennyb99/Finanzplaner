package com.example.finanzplaner.model.finanzverwaltung;

import androidx.room.Entity;

import com.example.finanzplaner.db.DB;

@Entity(tableName = "income_table")
public class Einnahme extends Eintrag {

    private Einnahmekategorie einnahmekategorie;

    public Einnahme(String name, float betrag, boolean wiederkehrend, Einnahmekategorie einnahmekategorie) {
        super(name, betrag, wiederkehrend);
        setId(DB.einnahmeIdCounter);
        DB.einnahmeIdCounter++;
        this.einnahmekategorie = einnahmekategorie;
    }

    public Einnahme(String name, float betrag, boolean wiederkehrend, Einnahmekategorie einnahmekategorie, String datum) {
        super(name, betrag, wiederkehrend, datum);
        setId(DB.einnahmeIdCounter);
        DB.einnahmeIdCounter++;
        this.einnahmekategorie = einnahmekategorie;
    }

    //Getter und Setter
    public Einnahmekategorie getEinnahmekategorie() {
        return einnahmekategorie;
    }

    public void setEinnahmekategorie(Einnahmekategorie einnahmekategorie) {
        this.einnahmekategorie = einnahmekategorie;
    }

}