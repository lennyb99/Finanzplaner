package com.example.finanzplaner.model.finanzverwaltung;

public class Einnahmekategorie {

    public Einnahmekategorie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString(){
        return name;
    }

}
