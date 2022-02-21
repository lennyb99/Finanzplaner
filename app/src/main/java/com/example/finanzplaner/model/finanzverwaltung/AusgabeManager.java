package com.example.finanzplaner.model.finanzverwaltung;

import android.util.Log;

import com.example.finanzplaner.db.DB;

import java.util.List;

public class AusgabeManager {

    private static List<Ausgabe> ausgaben;

    public AusgabeManager(){

    }

    public static void addAusgabe(Ausgabe ausgabe){
        Log.v("mydebug",ausgabe.getName()+ausgabe.getBetrag()+ausgabe.isWiederkehrend()+ausgabe.getAusgabekategorie().toString());
        ausgaben.add(ausgabe);
        DB.ausgabe.insertAusgabe(ausgabe);
    }

    public static void delAusgabe(String name){

    }

    public static List<Ausgabe> getAusgaben() {
        return ausgaben;
    }

    public static void setAusgaben(List<Ausgabe> ausgaben) {
        AusgabeManager.ausgaben = ausgaben;
    }
}
