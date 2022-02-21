package com.example.finanzplaner.model.finanzverwaltung;

import androidx.room.Entity;

@Entity(tableName = "expenseCateogries_table")
public class Ausgabekategorie extends Kategorie{

    public Ausgabekategorie(String name) {
        super(name);
    }

}