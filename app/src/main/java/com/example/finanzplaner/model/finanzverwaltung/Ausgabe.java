package com.example.finanzplaner.model.finanzverwaltung;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity (tableName = "expense_table")
public class Ausgabe {

    @PrimaryKey @NonNull
    private int id;
    private String name;
    //private float betrag;
    private String datum;
    private boolean repetetiv;
    //private Ausgabekategorie ausgabekategorie;

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public boolean isRepetetiv() {
        return repetetiv;
    }

    public void setRepetetiv(boolean repetetiv) {
        this.repetetiv = repetetiv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){this.id = id;}

    public Ausgabe(){
        datum = Calendar.getInstance().toString();
    }

}
