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
        Log.v("TESTXX", e.toString());
        einnahmeDao.insertEinnahme(e);
        List<Einnahme> l = einnahmeDao.getAllEinnahmen();
        List<Einnahme> l1 = einnahmeDao.getAllEinnahmen();

        Log.v("TESTXX", l.get(0).toString());
        Log.v("TESTXX1", l1.get(0).toString());
        Log.v("TESTXX", l.get(0).toString());
    }

}