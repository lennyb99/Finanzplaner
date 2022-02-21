package com.example.finanzplaner.model.finanzverwaltung;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finanzplaner.db.DB;
import com.example.finanzplaner.model.IObservable;
import com.example.finanzplaner.view.IObserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Verwaltung implements IObservable, Serializable {



    public Verwaltung(){

    }

    @Override
    public void anmelden(IObserver view) {
        ViewManager.anmelden(view);
    }

    @Override
    public void abmelden(IObserver view) {
        ViewManager.abmelden(view);
    }

    @Override
    public void benachrichtigeBeobachter() {
        ViewManager.benachrichtigeBeobachter();
    }

    public void addAusgabe(Ausgabe ausgabe){
        AusgabeManager.addAusgabe(ausgabe);
        benachrichtigeBeobachter();
    }

    public void delAusgabe(String name){
        AusgabeManager.delAusgabe(name);
        benachrichtigeBeobachter();
    }

    public List<Ausgabe> getAusgaben(){
        return AusgabeManager.getAusgaben();
    }

    public void setAusgaben(List<Ausgabe> ausgaben){
        AusgabeManager.setAusgaben(ausgaben);
        benachrichtigeBeobachter();
    }

    public void addEinnahme(Einnahme einnahme){
        EinnahmeManager.addEinnahme(einnahme);
        benachrichtigeBeobachter();
    }

    public void delEinnahme(String name){
        benachrichtigeBeobachter();
    }

    public List<Einnahme> getEinnahmen(){
        return EinnahmeManager.getEinnahmen();
    }

    public void setEinnahmen(List<Einnahme> einnahmen) {
        EinnahmeManager.setEinnahmen(einnahmen);
        benachrichtigeBeobachter();
    }

    public void getEinnahmenFromDB() {
        EinnahmeManager.getEinnahmenFromDB();
    }



    public void addAusgabekategorie(Ausgabekategorie kat){
        AusgabekategorieManager.addAusgabekategorie(kat);
        benachrichtigeBeobachter();
    }

    public void delAusgabekategorie(String name){
        AusgabekategorieManager.delAusgabekategorie(name);
        benachrichtigeBeobachter();
    }

    public List<String> getAusgabekategorieItemsString(){
        return AusgabekategorieManager.getAusgabekategorieItemsString();
    }

    public List<Ausgabekategorie> getAusgabekategorieItems(){
        return AusgabekategorieManager.getAusgabekategorieList();
    }

    public Ausgabekategorie findAusgabekategorie(String name){
        return AusgabekategorieManager.findAusgabekategorie(name);
    }

    public void addEinnahmekategorie(Einnahmekategorie kat){
        EinnahmekategorieManager.addEinnahmekategorie(kat);
        benachrichtigeBeobachter();
    }

    public void delEinnahmekategorie(String name){
        EinnahmekategorieManager.delEinnahmekategorie(name);
        benachrichtigeBeobachter();
    }

    public List<String> getEinnahmekategorieItemsString(){
        return EinnahmekategorieManager.getEinnahmekategorieItemsString();
    }

    public List<Einnahmekategorie> getEinnahmekategorieItems(){
        return EinnahmekategorieManager.getEinnahmekategorieList();
    }

    public Einnahmekategorie findEinnahmekategorie(String name){
        return EinnahmekategorieManager.findEinnahmekategorie(name);
    }

    public Map<Ausgabekategorie,Float> getKategoriegewichtungen(){
        Map<Ausgabekategorie,Float> gewichtungen = new HashMap<Ausgabekategorie, Float>();
        for (Ausgabekategorie ausgabekategorie: AusgabekategorieManager.getAusgabekategorieList()) {
            gewichtungen.put(ausgabekategorie,0f);
        }

        for (Ausgabe ausgabe: AusgabeManager.getAusgaben() ) {
            gewichtungen.put(ausgabe.getAusgabekategorie(), gewichtungen.get(ausgabe.getAusgabekategorie()) + ausgabe.getBetrag());
        }
        return gewichtungen;
    }

}
