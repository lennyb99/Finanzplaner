package com.example.finanzplaner.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class EintraegeLoeschenControllerTest {

    @Test
    public void getIdFromString() {


        EintraegeLoeschenController eintraegeLoeschenController = new EintraegeLoeschenController();

        assertEquals(eintraegeLoeschenController.getIdFromString("13;Miete;400.00;Miete") ,13);
        assertEquals(eintraegeLoeschenController.getIdFromString("18;Miete;400.00;Miete") , 18);
        assertNotEquals(eintraegeLoeschenController.getIdFromString("19;Miete;400.00;Miete") , 18);
        assertNotEquals(eintraegeLoeschenController.getIdFromString("19;Miete;400.00;Miete") , 20);
        assertEquals(eintraegeLoeschenController.getIdFromString("1343;Miete;400.00;Miete") , 1343);
        assertNotEquals(eintraegeLoeschenController.getIdFromString("136;Miete;400.00;Miete"), 13);

    }
}