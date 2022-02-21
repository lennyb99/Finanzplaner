package com.example.finanzplaner.model.finanzverwaltung;

import android.util.Log;

import com.example.finanzplaner.db.DB;

import java.util.ArrayList;
import java.util.List;

public class EinnahmekategorieManager {

    private static List<Einnahmekategorie> einnahmekategorieList;

    public EinnahmekategorieManager(){
        einnahmekategorieList = new ArrayList<>();
    }

    public static void addEinnahmekategorie(Einnahmekategorie kat){
        for (Einnahmekategorie ek: einnahmekategorieList) {
            if(ek.getName().equals(kat.getName())){
                return;
            }
        }
        Log.v("mydebug", "neue Einnahmekategorie wird gespeichert.");
        einnahmekategorieList.add(kat);
        DB.einnahmekategorie.insertEinnahmekategorie(kat);

    }

    public static void delEinnahmekategorie(String name){

    }

    public static Einnahmekategorie findEinnahmekategorie(String name){
        for (Einnahmekategorie ek: einnahmekategorieList) {
            if(ek.getName().equals(name)){
                return ek;
            }
        }
        return null;
    }

    public static List<Einnahmekategorie> getEinnahmekategorieList() {
        return einnahmekategorieList;
    }

    public static void setEinnahmekategorieList(List<Einnahmekategorie> einnahmekategorieList) {
        EinnahmekategorieManager.einnahmekategorieList = einnahmekategorieList;
    }

    public static List<String> getEinnahmekategorieItemsString(){
        List<String> temp = new ArrayList<>();
        for (Einnahmekategorie kategorie: einnahmekategorieList) {
            temp.add(kategorie.getName());
        }
        return temp;
    }



}
