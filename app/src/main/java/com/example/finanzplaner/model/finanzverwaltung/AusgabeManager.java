package com.example.finanzplaner.model.finanzverwaltung;

import android.util.Log;

import com.example.finanzplaner.db.DB;

import java.util.ArrayList;
import java.util.List;

public class AusgabeManager {

    private static List<Ausgabe> ausgaben;

    public AusgabeManager(){
        ausgaben = new ArrayList<>();
    }

    public static void addAusgabe(Ausgabe ausgabe){
        Log.v("mydebug",ausgabe.getName()+ausgabe.getBetrag()+ausgabe.isWiederkehrend()+ausgabe.getAusgabekategorie().toString());
        ausgaben.add(ausgabe);
        DB.ausgabe.insertAusgabe(ausgabe);
    }

    public static void delAusgabe(int id){
        for (int i = 0; i<ausgaben.size();i++) {
            if(ausgaben.get(i).getId() == id){
                ausgaben.remove(i);
            }
        }
        DB.ausgabe.deleteAusgabe(id);
    }

    public static List<Ausgabe> getAusgaben() {
        return ausgaben;
    }

    public static void setAusgaben(List<Ausgabe> ausgaben) {
        AusgabeManager.ausgaben = ausgaben;
    }

    public static void receiveAusgabenFromDB(List<Ausgabe> ausgabenDB){
        for (Ausgabe ausgabe : ausgabenDB) {
            ausgaben.add(ausgabe);
        }


    }


}
