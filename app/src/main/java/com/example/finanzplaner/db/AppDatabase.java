package com.example.finanzplaner.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;

@Database(entities = {Einnahme.class, Ausgabe.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EinnahmeDao einnahmeDao();
    public abstract AusgabeDao ausgabeDao();

}
