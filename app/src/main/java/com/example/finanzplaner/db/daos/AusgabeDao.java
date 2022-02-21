package com.example.finanzplaner.db.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;

import java.util.List;

@Dao
public interface AusgabeDao {

    @Insert
    public void insertAusgabe(Ausgabe a);

    @Delete
    public void deleteAusgabe(Ausgabe a);

    @Query("DELETE FROM expense_table WHERE id = :id")
    public void deleteAusgabe(int id);

    @Update
    public void updateAusgabe(Ausgabe a);

    @Query("SELECT * FROM expense_table")
    public List<Ausgabe> getAllAusgaben();

    @Query("SELECT MAX(id) from expense_table")
    public int getHighestId();

}