package com.example.finanzplaner.model.finanzverwaltung;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AusgabeTest {
    Ausgabe ausgabe;
    Ausgabe ausgabe2;
    Ausgabekategorie ausgabekategorie;
    Ausgabekategorie ausgabekategorie2;

    @Before
    public void setup(){
        ausgabekategorie = new Ausgabekategorie("Geschenk");
        ausgabekategorie2 = new Ausgabekategorie("Urlaub");
        ausgabe = new Ausgabe("Weihnachten", 200.0f, false, ausgabekategorie);
        ausgabe2 = new Ausgabe("Weihnachten", 200.0f, false, ausgabekategorie2);
    }

    @Test
    public void getAusgabekategorie() {
        assertEquals(ausgabe.getAusgabekategorie(),ausgabekategorie);
        assertNotEquals(ausgabe.getAusgabekategorie(),ausgabe2.getAusgabekategorie());
    }

    @Test
    public void setAusgabekategorie() {
        ausgabe2.setAusgabekategorie(ausgabekategorie);
        assertEquals(ausgabe.getAusgabekategorie(), ausgabe2.getAusgabekategorie());

    }
}