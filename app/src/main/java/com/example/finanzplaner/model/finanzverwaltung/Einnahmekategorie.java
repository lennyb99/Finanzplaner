package com.example.finanzplaner.model.finanzverwaltung;

import androidx.room.Entity;

import java.io.Serializable;

@Entity (tableName = "incomeCategories_table")
public class Einnahmekategorie extends Kategorie {

    public Einnahmekategorie(String name) {
        super(name);
    }

}