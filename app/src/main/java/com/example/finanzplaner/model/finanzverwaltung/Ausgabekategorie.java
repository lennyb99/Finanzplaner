package com.example.finanzplaner.model.finanzverwaltung;

public class Ausgabekategorie {

    public Ausgabekategorie(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

}
