package com.example.finanzplaner.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;

import java.util.ArrayList;
import java.util.List;

@Dao

public interface AusgabeDao {

    @Insert
    public void insertAusgabe(Ausgabe e);

    @Delete
    public void deleteAusgabe(Ausgabe e);

    @Update
    public void updateAusgabe(Ausgabe e);

    @Query("SELECT * FROM expense_table")
    public ArrayList<Ausgabe> getAllAusgaben();


}