package com.example.finanzplaner.model.finanzverwaltung;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "incomeCategories_table")
public class Einnahmekategorie {

    @PrimaryKey @NonNull
    private String name;

    public Einnahmekategorie(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    //Getter und Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}