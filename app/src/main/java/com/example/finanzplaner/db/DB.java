package com.example.finanzplaner.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;

@Database(entities = {Einnahme.class, Einnahmekategorie.class}, version = 1)
public abstract class DB extends RoomDatabase {

    public static DB db;
    public static EinnahmeDao einnahme;
    public static EinnahmeDao ausgabe;

    public abstract EinnahmeDao getEinnahmeDao();
    public abstract EinnahmeDao getAusgabeDao();

}