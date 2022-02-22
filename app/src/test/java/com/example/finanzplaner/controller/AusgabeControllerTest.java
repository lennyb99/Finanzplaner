package com.example.finanzplaner.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class AusgabeControllerTest {

    @Test
    public void ueberpruefeDatumEingabe() {

        AusgabeController ausgabeController = new AusgabeController();

        assertFalse(ausgabeController.ueberpruefeDatumEingabe("01-13-2022"));
        assertFalse(ausgabeController.ueberpruefeDatumEingabe("13-01-2022"));
        assertFalse(ausgabeController.ueberpruefeDatumEingabe("1-13-2022"));
        assertFalse(ausgabeController.ueberpruefeDatumEingabe("13-1-2022"));
        assertFalse(ausgabeController.ueberpruefeDatumEingabe("01-13-20222"));
        assertFalse(ausgabeController.ueberpruefeDatumEingabe("01.13.2022"));
        assertFalse(ausgabeController.ueberpruefeDatumEingabe("2222-13-01"));
        assertTrue(ausgabeController.ueberpruefeDatumEingabe("2022-01-01"));
        assertTrue(ausgabeController.ueberpruefeDatumEingabe("2022-01-13"));
    }
}