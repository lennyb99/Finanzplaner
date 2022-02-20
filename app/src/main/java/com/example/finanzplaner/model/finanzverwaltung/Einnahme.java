package com.example.finanzplaner.model.finanzverwaltung;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity (tableName = "income_table")
public class Einnahme {

    @PrimaryKey(autoGenerate = true) @NonNull
    private int id;
    private String name;
    private float betrag;
    private String datum;
    private boolean wiederkehrend;
    //private Einnahmekategorie einnahmekategorie;

    public Einnahme(String name, boolean repetetiv) {
        this.name = name;
        this.wiederkehrend = repetetiv;
        datum = Calendar.getInstance().toString();
    }

    //Getter und Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public boolean isRepetetiv() {
        return wiederkehrend;
    }

    public void setRepetetiv(boolean repetetiv) {
        this.wiederkehrend = repetetiv;
    }



}
