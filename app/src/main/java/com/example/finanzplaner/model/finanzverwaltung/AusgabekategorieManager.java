package com.example.finanzplaner.model.finanzverwaltung;

import android.util.Log;

import com.example.finanzplaner.db.DB;

import java.util.ArrayList;
import java.util.List;

public class AusgabekategorieManager {

    private static List<Ausgabekategorie> ausgabekategorieList;

    public AusgabekategorieManager(){
        ausgabekategorieList = new ArrayList<>();
    }

    public static void addAusgabekategorie(Ausgabekategorie kat){
        for (Ausgabekategorie ak: ausgabekategorieList) {
            if(ak.getName().equals(kat.getName())){
                return;
            }
        }
        Log.v("mydebug", "neue Ausgabekategorie wird gespeichert.");
        ausgabekategorieList.add(kat);
        DB.ausgabekategorie.insertAusgabekategorie(kat);
    }

    public static void delAusgabekategorie(String name){

    }

    public static List<String> getAusgabekategorieItemsString(){
        List<String> temp = new ArrayList<>();
        for (Ausgabekategorie kategorie: ausgabekategorieList) {
            temp.add(kategorie.getName());
        }
        return temp;
    }

    public static Ausgabekategorie findAusgabekategorie(String name){
        for (Ausgabekategorie ak: ausgabekategorieList) {
            if(ak.getName().equals(name)){
                return ak;
            }
        }
        return null;
    }

    public static List<Ausgabekategorie> getAusgabekategorieList() {
        return ausgabekategorieList;
    }

    public static void setAusgabekategorieList(List<Ausgabekategorie> ausgabekategorien) {
        ausgabekategorieList = ausgabekategorien;
    }



}
