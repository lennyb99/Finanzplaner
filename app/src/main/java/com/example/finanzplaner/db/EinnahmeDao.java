package com.example.finanzplaner.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finanzplaner.model.finanzverwaltung.Einnahme;

@Dao
public interface EinnahmeDao {

    @Query("FROM USERS")
    public void insertEinnahmen(Einnahme... einnahme);




}
