package com.example.finanzplaner.DbTests;

import android.content.Context;

import static org.junit.Assert.*;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.finanzplaner.db.DB;
import com.example.finanzplaner.db.daos.AusgabekategorieDao;
import com.example.finanzplaner.db.daos.EinnahmekategorieDao;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class KategorieTests {

    private DB db;
    private EinnahmekategorieDao ekDao;
    private AusgabekategorieDao akDao;

    @Before
    public void setupDB() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, DB.class).build();
        ekDao = db.getEinnahmekategorieDao();
        akDao = db.getAusgabekategorieDao();
    }

    @After
    public void closeDb()  {
        db.close();
    }

    @Test
    public void insert() {
        assertEquals(ekDao.getAllEinnahmekategorien().size(), 0);
        assertEquals(akDao.getAllAusgabekategorien().size(), 0);

        Einnahmekategorie ek1 = new Einnahmekategorie("Einnahmekategorie1");
        Einnahmekategorie ek1_5 = new Einnahmekategorie("Einnahmekategorie1");
        Einnahmekategorie ek2 = new Einnahmekategorie("Einnahmekategorie2");
        Einnahmekategorie ek3 = new Einnahmekategorie("Einnahmekategorie3");
        Ausgabekategorie ak1 = new Ausgabekategorie("Ausgabekategorie1");
        Ausgabekategorie ak2 = new Ausgabekategorie("Ausgabekategorie2");
        Ausgabekategorie ak3 = new Ausgabekategorie("Ausgabekategorie3");
        ekDao.insertEinnahmekategorie(ek1);
        ekDao.insertEinnahmekategorie(ek1_5);
        ekDao.insertEinnahmekategorie(ek2);
        ekDao.insertEinnahmekategorie(ek3);
        akDao.insertAusgabekategorie(ak1);
        akDao.insertAusgabekategorie(ak2);
        akDao.insertAusgabekategorie(ak3);

        List<Einnahmekategorie> el = ekDao.getAllEinnahmekategorien();
        List<Ausgabekategorie> al = akDao.getAllAusgabekategorien();

        assertEquals(el.size(), 3);
        assertEquals(al.size(), 3);

        assertEquals(el.get(0).getName(), ek1.getName());
        assertNotEquals(el.get(1).getName(), ek1.getName());

        assertEquals(ak2.getName(), al.get(1).getName());
    }

    @Test
    public void delete() {
        Einnahmekategorie ek1 = new Einnahmekategorie("Einnahmekategorie1");
        Einnahmekategorie ek2 = new Einnahmekategorie("Einnahmekategorie3");
        Ausgabekategorie ak1 = new Ausgabekategorie("Ausgabekategorie1");
        Ausgabekategorie ak2 = new Ausgabekategorie("Ausgabekategorie2");
        ekDao.insertEinnahmekategorie(ek1);
        ekDao.insertEinnahmekategorie(ek2);
        akDao.insertAusgabekategorie(ak1);
        akDao.insertAusgabekategorie(ak2);

        ekDao.deleteEinnahmekategorie(ek1);
        List<Einnahmekategorie> eL = ekDao.getAllEinnahmekategorien();
        assertNotEquals(ek1.getName(), eL.get(0).getName());
        assertEquals(ek2.getName(), eL.get(0).getName());

        List<Ausgabekategorie> aL = akDao.getAllAusgabekategorien();
        akDao.deleteAusgabekategorie("Ausgabekategorie1");
        akDao.deleteAusgabekategorie("Ausgabekategorie2");
        aL = akDao.getAllAusgabekategorien();
        assertTrue(aL.isEmpty());
    }

}
