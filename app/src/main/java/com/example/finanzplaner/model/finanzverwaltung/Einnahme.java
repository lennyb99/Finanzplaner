package com.example.finanzplaner.model.finanzverwaltung;


import java.util.Calendar;

enum einnahmeKategorien {}
public class Einnahme {

    private String name;
    private Calendar datum;
    private boolean repetetiv;
    
    public Einnahme(){
        datum = Calendar.getInstance();
    }


}
