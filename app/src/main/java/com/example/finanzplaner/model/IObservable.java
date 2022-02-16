package com.example.finanzplaner.model;

public interface IObservable {

    public void anmelden();
    public void abmelden();

    public void benachrichtigeBeobachter();

    public void gibAktuelleDaten();

}
