package com.example.finanzplaner.model.finanzverwaltung;

import com.example.finanzplaner.model.IObservable;
import com.example.finanzplaner.view.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Verwaltung implements IObservable {

    private List<Ausgabe> ausgaben;
    private List<Einnahme> einnahmen;

    private List<IObserver> views;


    public Verwaltung(){

        ausgaben = new ArrayList<>();
        einnahmen = new ArrayList<>();
        views = new ArrayList<>();

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


}
