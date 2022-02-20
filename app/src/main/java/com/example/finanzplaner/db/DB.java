package com.example.finanzplaner.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;

@Database(entities = {Einnahme.class, Ausgabe.class}, version = 1)
public abstract class DB extends RoomDatabase {

    public static DB db;
    public static EinnahmeDao einnahme;
    public static AusgabeDao ausgabe;

    public abstract EinnahmeDao getEinnahmeDao();
    public abstract AusgabeDao getAusgabeDao();

}