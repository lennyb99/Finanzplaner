package com.example.finanzplaner.model.finanzverwaltung;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EinnahmeTest {
    Einnahme einnahme;
    Einnahme einnahme2;
    Einnahmekategorie einnahmekategorie;
    Einnahmekategorie einnahmekategorie2;

    @Before
    public void setup(){
        einnahmekategorie = new Einnahmekategorie("Geschenk");
        einnahmekategorie2 = new Einnahmekategorie("Urlaub");
        einnahme = new Einnahme("Weihnachten", 200.0f, false, einnahmekategorie);
        einnahme2 = new Einnahme("Weihnachten", 200.0f, false, einnahmekategorie2);
    }

    @Test
    public void getEinnahmekategorie() {
        assertEquals(einnahme.getEinnahmekategorie(),einnahmekategorie);
        assertNotEquals(einnahme.getEinnahmekategorie(),einnahme2.getEinnahmekategorie());
    }

    @Test
    public void setEinnahmekategorie() {
        einnahme2.getEinnahmekategorie();
        assertEquals(einnahme.getEinnahmekategorie(), einnahme2.getEinnahmekategorie());
    }
}