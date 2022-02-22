package com.example.finanzplaner.db.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finanzplaner.model.finanzverwaltung.Einnahme;

import java.util.List;

@Dao
public interface EinnahmeDao {

    @Insert
    public void insertEinnahme(Einnahme e);

    @Query("SELECT * FROM income_table WHERE id = :id")
    public int getEinnahme(int id);

    @Delete
    public void deleteEinnahme(Einnahme e);

    @Query("DELETE FROM income_table WHERE id = :id")
    public void deleteEinnahme(int id);

    @Update
    public void updateEinnahme(Einnahme e);

    @Query("SELECT * FROM income_table")
    public List<Einnahme> getAllEinnahmen();

    @Query("SELECT MAX(id) from income_table")
    public int getHighestId();

}