package com.example.finanzplaner.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class EinnahmeControllerTest {

    @Test
    public void ueberpruefeDatumEingabe() {
        EinnahmeController einnahmeController = new EinnahmeController();

        assertFalse(einnahmeController.ueberpruefeDatumEingabe("01-13-2022"));
        assertFalse(einnahmeController.ueberpruefeDatumEingabe("13-01-2022"));
        assertFalse(einnahmeController.ueberpruefeDatumEingabe("1-13-2022"));
        assertFalse(einnahmeController.ueberpruefeDatumEingabe("13-1-2022"));
        assertFalse(einnahmeController.ueberpruefeDatumEingabe("01-13-20222"));
        assertFalse(einnahmeController.ueberpruefeDatumEingabe("01.13.2022"));
        assertFalse(einnahmeController.ueberpruefeDatumEingabe("2222-13-01"));
        assertTrue(einnahmeController.ueberpruefeDatumEingabe("2022-01-01"));
        assertTrue(einnahmeController.ueberpruefeDatumEingabe("2022-01-13"));

    }
}