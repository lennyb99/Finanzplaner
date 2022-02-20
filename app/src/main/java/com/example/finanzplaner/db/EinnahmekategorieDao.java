package com.example.finanzplaner.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;

@Dao
public interface EinnahmekategorieDao {

    @Insert
    public void insertEinnahmekategorie(Einnahmekategorie e);

    @Delete
    public void deleteEinnahmekategorie(Einnahmekategorie e);

    @Update
    public void updateEinnahmekategorie(Einnahmekategorie e);

}
