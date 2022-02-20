package com.example.finanzplaner.model.finanzverwaltung;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity (tableName = "expense_table")
public class Ausgabe {

    @PrimaryKey @NonNull
    private String name;
    private float betrag;
    private String datum;
    private boolean repetetiv;
    private Ausgabekategorie ausgabekategorie;

    public Ausgabe(){
        datum = Calendar.getInstance().toString();
    }

}
