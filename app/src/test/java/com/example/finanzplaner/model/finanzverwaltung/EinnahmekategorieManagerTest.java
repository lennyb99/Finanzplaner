package com.example.finanzplaner.model.finanzverwaltung;

import org.junit.Test;

import static org.junit.Assert.*;

public class EinnahmekategorieManagerTest {



    @Test
    public void addEinnahmekategorie() {
        EinnahmekategorieManager einnahmekategorieManager = new EinnahmekategorieManager();
        assertEquals(EinnahmekategorieManager.getEinnahmekategorieList().size(), 0);
        EinnahmekategorieManager.addEinnahmekategorie(new Einnahmekategorie("b"));
        assertEquals(EinnahmekategorieManager.getEinnahmekategorieList().size(), 1);
    }

    @Test
    public void findEinnahmekategorie() {
        EinnahmekategorieManager einnahmekategorieManager = new EinnahmekategorieManager();
        Einnahmekategorie einnahmekategorie = new Einnahmekategorie("b");
        EinnahmekategorieManager.addEinnahmekategorie(einnahmekategorie);
        assertEquals(EinnahmekategorieManager.findEinnahmekategorie("b"),einnahmekategorie);
    }
}