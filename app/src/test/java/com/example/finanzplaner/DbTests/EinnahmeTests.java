package com.example.finanzplaner.DbTests;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.finanzplaner.db.DB;
import com.example.finanzplaner.db.daos.EinnahmeDao;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {

    }



}