package com.example.finanzplaner.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.finanzplaner.db.daos.AusgabeDao;
import com.example.finanzplaner.db.daos.AusgabekategorieDao;
import com.example.finanzplaner.db.daos.EinnahmeDao;
import com.example.finanzplaner.db.daos.EinnahmekategorieDao;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;

@Database(entities = {Einnahme.class, Ausgabe.class, Einnahmekategorie.class, Ausgabekategorie.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class DB extends RoomDatabase {

    public static int einnahmeIdCounter ;
    public static int ausgabeIdCounter ;

    public static DB db;

    public static EinnahmeDao einnahme;
    public static AusgabeDao ausgabe;
    public static EinnahmekategorieDao einnahmekategorie;
    public static AusgabekategorieDao ausgabekategorie;

    public abstract EinnahmeDao getEinnahmeDao();
    public abstract AusgabeDao getAusgabeDao();
    public abstract EinnahmekategorieDao getEinnahmekategorieDao();
    public abstract AusgabekategorieDao getAusgabekategorieDao();


    public void daoSetup() {
        DB.einnahme = DB.db.getEinnahmeDao();
        DB.ausgabe = DB.db.getAusgabeDao();
        DB.einnahmekategorie = DB.db.getEinnahmekategorieDao();
        DB.ausgabekategorie = DB.db.getAusgabekategorieDao();
    }

    public void initHighesIds() {
        einnahmeIdCounter = einnahme.getHighestId() + 1;
        ausgabeIdCounter = ausgabe.getHighestId() + 1;
    }

}