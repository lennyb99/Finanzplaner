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

    public static void delEinnahme(int id){
        for (int i = 0; i<einnahmen.size();i++) {
            if(einnahmen.get(i).getId() == id){
                einnahmen.remove(i);
            }
        }
        DB.einnahme.deleteEinnahme(id);
    }

    public static List<Einnahme> getEinnahmen() {
        return einnahmen;
    }

    public static void setEinnahmen(List<Einnahme> einnahmen) {
        EinnahmeManager.einnahmen = einnahmen;
    }

    public static void receiveEinnahmenFromDB(List<Einnahme> einnahmenDB) {
        for (Einnahme einnahme: einnahmenDB) {
            einnahmen.add(einnahme);
        }
    }
}
