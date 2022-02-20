package com.example.finanzplaner.model.finanzverwaltung;

import android.util.Log;
import android.view.View;

import com.example.finanzplaner.db.DB;
import com.example.finanzplaner.model.IObservable;
import com.example.finanzplaner.view.IObserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Verwaltung implements IObservable, Serializable {

    private List<Ausgabe> ausgaben;
    private List<Einnahme> einnahmen;
    private List<Ausgabekategorie> ausgabekategorien;
    private List<Einnahmekategorie> einnahmekategorien;

    private List<IObserver> views;


    public Verwaltung(){

        ausgaben = new ArrayList<>();
        einnahmen = new ArrayList<>();
        views = new ArrayList<>();
        ausgabekategorien = new ArrayList<>();
        einnahmekategorien = new ArrayList<>();



    }

    public void addAusgabekategorie(Ausgabekategorie kat){
        ausgabekategorien.add(kat);
    }

    public void addEinnahmekategorie(Einnahmekategorie kat){
        einnahmekategorien.add(kat);
    }

    public void addAusgabe(Ausgabe ausgabe){
        ausgaben.add(ausgabe);
        Log.v("mydebug",ausgabe.getName()+ausgabe.getBetrag()+ausgabe.isWiederkehrend()+ausgabe.getAusgabekategorie().toString());
        DB.ausgabe.insertAusgabe(ausgabe);

    }

    public void addEinnahme(Einnahme einnahme){
        einnahmen.add(einnahme);
        Log.v("mydebug",einnahme.getName()+einnahme.getBetrag()+einnahme.isWiederkehrend()+einnahme.getEinnahmekategorie().toString());
        DB.einnahme.insertEinnahme(einnahme);
    }

    public void delAusgabe(String name){

    }

    public void delEinnahme(String name){

    }

    public void delAusgabekategorie(String name){

    }

    public void delEinnahmekategorie(String name){

    }

    public void getEinnahmenFromDB() {
        einnahmen = DB.einnahme.getAllEinnahmen();
    }

    @Override
    public void anmelden(IObserver view) {
        views.add(view);
    }

    @Override
    public void abmelden(IObserver view) {
        views.remove(view);
    }

    @Override
    public void benachrichtigeBeobachter() {
        for (IObserver view: views) {
            view.update();
        }
    }

    @Override
    public void gibAktuelleDaten() {

    }


    public List<Ausgabe> getAusgaben(){
        return ausgaben;
    }

    public List<Einnahme> getEinnahmen(){
        return einnahmen;
    }

    public List<String> getAusgabekategorieItemsString(){
        ausgabekategorien.add(new Ausgabekategorie("Hund"));
        ausgabekategorien.add(new Ausgabekategorie("Urlaub"));
        ausgabekategorien.add(new Ausgabekategorie("Essen"));
        List<String> temp = new ArrayList<>();
        for (Ausgabekategorie kategorie: ausgabekategorien) {
            temp.add(kategorie.toString());
        }
        return temp;
    }

    public List<Ausgabekategorie> getAusgabekategorieItems(){
        return ausgabekategorien;
    }

    public Ausgabekategorie findAusgabekategorie(String name){
        for (Ausgabekategorie ak: ausgabekategorien) {
            if(ak.getName().equals(name)){
                return ak;
            }
        }
        return null;
    }

    public List<String> getEinnahmekategorieItemsString(){
        einnahmekategorien.add(new Einnahmekategorie("Taschengeld"));
        einnahmekategorien.add(new Einnahmekategorie("Beruf"));
        einnahmekategorien.add(new Einnahmekategorie("Nebenverdienst"));
        List<String> temp = new ArrayList<>();
        for (Einnahmekategorie kategorie: einnahmekategorien) {
            temp.add(kategorie.toString());
        }
        return temp;
    }

    public List<Einnahmekategorie> getEinnahmekategorieItems(){
        return einnahmekategorien;
    }

    public Einnahmekategorie findEinnahmekategorie(String name){
        for (Einnahmekategorie ek: einnahmekategorien) {
            if(ek.getName().equals(name)){
                return ek;
            }
        }
        return null;
    }

}
