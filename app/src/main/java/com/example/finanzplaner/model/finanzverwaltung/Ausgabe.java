package com.example.finanzplaner.model.finanzverwaltung;

import androidx.room.Entity;

@Entity (tableName = "expense_table")
public class Ausgabe extends Eintrag {

    private Ausgabekategorie ausgabekategorie;

    public Ausgabe(String name, float betrag, boolean wiederkehrend, Ausgabekategorie ausgabekategorie) {
        super(name, betrag, wiederkehrend);
        this.ausgabekategorie = ausgabekategorie;
    }

    //Getter und Setter
    public Ausgabekategorie getAk() {
        return ausgabekategorie;
    }

    public void setAk(Ausgabekategorie ausgabekategorie) {
        this.ausgabekategorie = ausgabekategorie;
    }

}