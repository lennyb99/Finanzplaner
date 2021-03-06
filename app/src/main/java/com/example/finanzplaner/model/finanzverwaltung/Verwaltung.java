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

import static com.example.finanzplaner.db.DB.einnahme;

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

    public void delAusgabe(int id){
        AusgabeManager.delAusgabe(id);
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

    public void delEinnahme(int id){
        EinnahmeManager.delEinnahme(id);
        benachrichtigeBeobachter();
    }

    public List<Einnahme> getEinnahmen(){
        return EinnahmeManager.getEinnahmen();
    }

    public void setEinnahmen(List<Einnahme> einnahmen) {
        EinnahmeManager.setEinnahmen(einnahmen);
        benachrichtigeBeobachter();
    }

    public void getEinnahmenFromDB(List<Einnahme> einnahmen) {
        EinnahmeManager.receiveEinnahmenFromDB(einnahmen);
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

    public Map<String,Float> getKategoriegewichtungen(){
        Map<String,Float> gewichtungen = new HashMap<String, Float>();
        for (Ausgabekategorie ausgabekategorie: AusgabekategorieManager.getAusgabekategorieList()) {
            gewichtungen.put(ausgabekategorie.getName(),0f);
        }
        for (Ausgabe ausgabe: AusgabeManager.getAusgaben() ) {
            gewichtungen.put(ausgabe.getAusgabekategorie().getName(), gewichtungen.get(ausgabe.getAusgabekategorie().getName()) + ausgabe.getBetrag());
        }
        return gewichtungen;
    }

    public List<Eintrag> getEintraege(){
        List<Eintrag> list = new ArrayList<>();
        for (Einnahme einnahme: EinnahmeManager.getEinnahmen() ) {
            list.add(einnahme);
        }
        for (Ausgabe ausgabe: AusgabeManager.getAusgaben() ) {
            list.add(ausgabe);
        }
        return list;
    }

    public float getBilanz(){
        float bilanz = 0;
        for (Einnahme einnahme: EinnahmeManager.getEinnahmen()) {
            bilanz += einnahme.getBetrag();
        }

        for (Ausgabe ausgabe:AusgabeManager.getAusgaben()) {
            bilanz -= ausgabe.getBetrag();
        }
        return bilanz;
    }



}
