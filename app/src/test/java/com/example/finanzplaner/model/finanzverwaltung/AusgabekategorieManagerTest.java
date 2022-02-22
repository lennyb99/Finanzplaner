package com.example.finanzplaner.model.finanzverwaltung;

import org.junit.Test;

import static org.junit.Assert.*;

public class AusgabekategorieManagerTest {


    @Test
    public void addAusgabekategorie() {
        AusgabekategorieManager ausgabekategorieManager = new AusgabekategorieManager();
        assertEquals(AusgabekategorieManager.getAusgabekategorieList().size(), 0);
        AusgabekategorieManager.addAusgabekategorie(new Ausgabekategorie("a"));
        assertEquals(AusgabekategorieManager.getAusgabekategorieList().size(), 1);
    }

    @Test
    public void findAusgabekategorie() {
        AusgabekategorieManager ausgabekategorieManager = new AusgabekategorieManager();
        Ausgabekategorie ausgabekategorie = new Ausgabekategorie("a");
        AusgabekategorieManager.addAusgabekategorie(ausgabekategorie);
        assertEquals(AusgabekategorieManager.findAusgabekategorie("a"),ausgabekategorie);
    }
}