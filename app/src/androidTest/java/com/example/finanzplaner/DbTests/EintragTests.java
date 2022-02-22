package com.example.finanzplaner.DbTests;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.finanzplaner.db.DB;
import com.example.finanzplaner.db.daos.AusgabeDao;
import com.example.finanzplaner.db.daos.EinnahmeDao;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class EintragTests {

    private DB db;
    private EinnahmeDao einnahmeDao;
    private AusgabeDao ausgabeDao;

    @Before
    public void setupDB() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, DB.class).build();
        einnahmeDao = db.getEinnahmeDao();
        ausgabeDao = db.getAusgabeDao();
    }

    @After
    public void closeDb()  {
        db.close();
    }

    @Test
    public void insert() {
        Einnahme e0 = new Einnahme("Gehalt", 3500.5f, true, new Einnahmekategorie("Job"));
        Einnahme e1 = new Einnahme("Gehalt Minijob", 42f, false, new Einnahmekategorie("Job"));
        Einnahme e2 = new Einnahme("Gehalt Minijob 3", 0.5f, true, new Einnahmekategorie("Illegal"));
        Ausgabe a0 = new Ausgabe("Miete", 200f, true, new Ausgabekategorie("Wohnen"));
        Ausgabe a1 = new Ausgabe("Brot", 5.2f, false, new Ausgabekategorie("Lebensmittel"));

        //Insert Einnahme
        einnahmeDao.insertEinnahme(e0);
        einnahmeDao.insertEinnahme(e1);
        einnahmeDao.insertEinnahme(e2);
        List<Einnahme> lE = einnahmeDao.getAllEinnahmen();

        //Das id-Attribut ist unique, deshalb wird danach getestet
        assertEquals(lE.size(), 3);
        assertEquals(e0.getId(), lE.get(0).getId());
        assertEquals(e1.getId(), lE.get(1).getId());
        assertEquals(e2.getId(), lE.get(2).getId());
        assertNotEquals(e0.getId(), lE.get(1).getId());
        assertNotEquals(e1.getId(), lE.get(0).getId());

        //Insert Ausgabe
        ausgabeDao.insertAusgabe(a0);
        ausgabeDao.insertAusgabe(a1);
        List<Ausgabe> lA = ausgabeDao.getAllAusgaben();

        assertEquals(lA.size(), 2);
        assertEquals(a0.getId(), lA.get(0).getId());
        assertEquals(a1.getId(), lA.get(1).getId());
        assertNotEquals(a1.getId(), lA.get(0).getId());
        assertNotEquals(a0.getId(), lA.get(1).getId());
    }

    @Test
    public void delete() {
        assertTrue(einnahmeDao.getAllEinnahmen().isEmpty());

        Einnahme e = new Einnahme("Gehalt", 3500.5f, true, new Einnahmekategorie("Job"));
        Einnahme e1 = new Einnahme("Gehalt2", 42221f, true, new Einnahmekategorie("Anderer Job"));
        einnahmeDao.insertEinnahme(e);
        einnahmeDao.insertEinnahme(e1);

        List<Einnahme> l = einnahmeDao.getAllEinnahmen();
        assertEquals(l.size(), 2);

        einnahmeDao.deleteEinnahme(e);
        l = einnahmeDao.getAllEinnahmen();
        assertEquals(l.size(), 1);
        assertNotEquals(e.getId(), l.get(0).getId());

        einnahmeDao.deleteEinnahme(1);
        l = einnahmeDao.getAllEinnahmen();
        assertTrue(l.isEmpty());

    }

    @Test
    public void highestID() {
        Einnahme e0 = new Einnahme("Gehalt", 3500.5f, true, new Einnahmekategorie("Job"));
        Einnahme e1 = new Einnahme("Gehalt Minijob", 42f, false, new Einnahmekategorie("Job"));
        Einnahme e2 = new Einnahme("Gehalt Minijob 3", 0.5f, true, new Einnahmekategorie("Illegal"));
        Einnahme e3 = new Einnahme("Gehalt", 3500.5f, true, new Einnahmekategorie("Job"));
        Einnahme e4 = new Einnahme("Gehalt Minijob", 42f, false, new Einnahmekategorie("Job"));
        Einnahme e5 = new Einnahme("Gehalt Minijob 3", 0.5f, true, new Einnahmekategorie("Illegal"));
        einnahmeDao.insertEinnahme(e0);
        einnahmeDao.insertEinnahme(e1);
        einnahmeDao.insertEinnahme(e2);
        einnahmeDao.insertEinnahme(e3);
        einnahmeDao.insertEinnahme(e4);
        einnahmeDao.insertEinnahme(e5);
        Ausgabe a0 = new Ausgabe("Miete", 200f, true, new Ausgabekategorie("Wohnen"));
        Ausgabe a1 = new Ausgabe("Brot", 5.2f, false, new Ausgabekategorie("Lebensmittel"));
        Ausgabe a2 = new Ausgabe("Miete", 200f, true, new Ausgabekategorie("Wohnen"));
        Ausgabe a3 = new Ausgabe("Brot", 5.2f, false, new Ausgabekategorie("Lebensmittel"));
        ausgabeDao.insertAusgabe(a0);
        ausgabeDao.insertAusgabe(a1);
        ausgabeDao.insertAusgabe(a2);
        ausgabeDao.insertAusgabe(a3);

        assertEquals(ausgabeDao.getHighestId(), 3);
        assertEquals(einnahmeDao.getHighestId(), 5);
    }
}