package com.example.finanzplaner.model.finanzverwaltung;

import android.util.Log;

import com.example.finanzplaner.db.DB;

import java.util.ArrayList;
import java.util.List;

public class EinnahmeManager {

    private static List<Einnahme> einnahmen;

    public EinnahmeManager(){
        einnahmen = new ArrayList<>();
    }

    public static void addEinnahme(Einnahme einnahme){
        Log.v("mydebug",einnahme.getName()+einnahme.getBetrag()+einnahme.isWiederkehrend()+einnahme.getEinnahmekategorie().toString());
        einnahmen.add(einnahme);
        DB.einnahme.insertEinnahme(einnahme);
    }

    public static void delEinnahme(String name){

    }

    public static List<Einnahme> getEinnahmen() {
        return einnahmen;
    }

    public static void setEinnahmen(List<Einnahme> einnahmen) {
        EinnahmeManager.einnahmen = einnahmen;
    }

    public static void getEinnahmenFromDB() {
        einnahmen = DB.einnahme.getAllEinnahmen();
    }
}
