package com.example.finanzplaner.model.finanzverwaltung;

import java.util.ArrayList;
import java.util.List;

public class Verwaltung {

    private List<Ausgabe> ausgaben;
    private List<Einnahme> einnahmen;

    public Verwaltung(){

        ausgaben = new ArrayList<>();
        einnahmen = new ArrayList<>();

    }

    public void addAusgabe(Ausgabe ausgabe){
        ausgaben.add(ausgabe);
    }

    public void addEinnahme(Einnahme einnahme){
        einnahmen.add(einnahme);
    }

    public void delAusgabe(String name){

    }

    public void delEinnahme(String name){

    }
}
