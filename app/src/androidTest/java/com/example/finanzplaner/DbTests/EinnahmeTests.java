package com.example.finanzplaner.DbTests;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.finanzplaner.db.DB;
import com.example.finanzplaner.db.daos.EinnahmeDao;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class EinnahmeTests {

    private DB db;
    private EinnahmeDao einnahmeDao;

    @Before
    public void setupDB() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, DB.class).build();
        einnahmeDao = db.getEinnahmeDao();
    }

    @After
    public void closeDb()  {
        db.close();
    }

    @Test
    public void insert() {
        Einnahme e = new Einnahme("Gehalt", 3500.5f, true, new Einnahmekategorie("Job"));
        Einnahme e1 = new Einnahme("Gehalt", 3500.5f, true, new Einnahmekategorie("Job"));
        einnahmeDao.insertEinnahme(e);
        einnahmeDao.insertEinnahme(e1);
        List<Einnahme> l = einnahmeDao.getAllEinnahmen();

        //Das id-Attribut ist unique, deshalb wird danach getestet
        assertEquals(e.getId(), l.get(0).getId());
        assertEquals(e1.getId(), l.get(1).getId());
        assertNotEquals(e.getId(), l.get(1).getId());
        assertNotEquals(e1.getId(), l.get(0).getId());
    }

    @Test
    public void delete() {
        Einnahme e = new Einnahme("Gehalt", 3500.5f, true, new Einnahmekategorie("Job"));
        Einnahme e1 = new Einnahme("Gehalt2", 42221f, true, new Einnahmekategorie("Anderer Job"));
        Einnahme e2 = new Einnahme("Gehalt3", 424242f, true, new Einnahmekategorie("Minijob"));
        Einnahme e3 = new Einnahme("Gehalt4", 322f, true, new Einnahmekategorie("Job"));
        einnahmeDao.insertEinnahme(e);
        einnahmeDao.insertEinnahme(e1);
        einnahmeDao.insertEinnahme(e2);
        einnahmeDao.insertEinnahme(e3);

        List<Einnahme> l = einnahmeDao.getAllEinnahmen();

        assertEquals(l.size(), 4);

        einnahmeDao.deleteEinnahme(e);
        //assertEquals(einnahmeDao.getAllEinnahmen().contains());


    }
}