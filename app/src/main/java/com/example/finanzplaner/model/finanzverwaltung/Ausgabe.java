package com.example.finanzplaner.model.finanzverwaltung;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;

enum ausgabeKategorien {}

@Entity (tableName = "expense_table")
public class Ausgabe {

    @PrimaryKey @NonNull
    public String name;
    public String datum;
    public boolean repetetiv;

    public Ausgabe(){
        datum = Calendar.getInstance().toString();
    }

}
