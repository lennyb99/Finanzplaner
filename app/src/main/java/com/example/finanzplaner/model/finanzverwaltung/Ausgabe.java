package com.example.finanzplaner.model.finanzverwaltung;


import java.util.Calendar;

enum ausgabeKategorien {}
public class Ausgabe {

    private String name;
    private Calendar datum;
    private boolean repetetiv;

    public Ausgabe(){
        datum = Calendar.getInstance();
    }

}
