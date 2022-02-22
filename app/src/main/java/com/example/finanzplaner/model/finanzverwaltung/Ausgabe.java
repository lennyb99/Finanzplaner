package com.example.finanzplaner.model.finanzverwaltung;

import androidx.room.Entity;

import com.example.finanzplaner.db.DB;

@Entity(tableName = "expense_table")
public class Ausgabe extends Eintrag {

    private Ausgabekategorie ausgabekategorie;

    public Ausgabe(String name, float betrag, boolean wiederkehrend, Ausgabekategorie ausgabekategorie) {
        super(name, betrag, wiederkehrend);
        setId(DB.ausgabeIdCounter);
        DB.ausgabeIdCounter++;
        this.ausgabekategorie = ausgabekategorie;
    }

    public Ausgabe(String name, float betrag, boolean wiederkehrend, Ausgabekategorie ausgabekategorie, String datum) {
        super(name, betrag, wiederkehrend, datum);
        setId(DB.ausgabeIdCounter);
        DB.ausgabeIdCounter++;
        this.ausgabekategorie = ausgabekategorie;
    }

    //Getter und Setter
    public Ausgabekategorie getAusgabekategorie() {
        return ausgabekategorie;
    }

    public void setAusgabekategorie(Ausgabekategorie ausgabekategorie) {
        this.ausgabekategorie = ausgabekategorie;
    }

}