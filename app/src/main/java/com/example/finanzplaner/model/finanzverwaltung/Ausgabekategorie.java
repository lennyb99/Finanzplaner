package com.example.finanzplaner.model.finanzverwaltung;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "expenseCateogries_table")
public class Ausgabekategorie {

    @PrimaryKey @NonNull
    private String name;

    public Ausgabekategorie(String name) {
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