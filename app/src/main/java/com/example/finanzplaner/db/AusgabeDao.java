package com.example.finanzplaner.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;

import java.util.List;

@Dao

public interface AusgabeDao {

    @Insert
    public void insertAusgabe(Ausgabe a);

    @Delete
    public void deleteAusgabe(Ausgabe a);

    @Update
    public void updateAusgabe(Ausgabe a);

    @Query("SELECT * FROM expense_table")
    public List<Ausgabe> getAllAusgaben();

}
