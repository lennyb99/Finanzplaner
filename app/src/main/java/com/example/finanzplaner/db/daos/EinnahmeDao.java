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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertEinnahme(Einnahme e);

    @Delete
    public void deleteEinnahme(Einnahme e);

    @Update
    public void updateEinnahme(Einnahme e);

    @Query("SELECT * FROM income_table")
    public List<Einnahme> getAllEinnahmen();

}