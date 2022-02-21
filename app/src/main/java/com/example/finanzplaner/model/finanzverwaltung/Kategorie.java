package com.example.finanzplaner.model.finanzverwaltung;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import java.io.Serializable;

public abstract class Kategorie {

    @PrimaryKey @NonNull
    private String name;

    public Kategorie(String name) {
        this.name = name;
    }

    //Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}