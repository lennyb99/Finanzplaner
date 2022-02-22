package com.example.finanzplaner.db.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;

import java.util.List;

@Dao
public interface EinnahmekategorieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertEinnahmekategorie(Einnahmekategorie e);

    @Delete
    public void deleteEinnahmekategorie(Einnahmekategorie e);

    @Query("DELETE FROM incomeCategories_table WHERE name = :name")
    public void deleteEinnahmekategorie(String name);

    @Update
    public void updateEinnahmekategorie(Einnahmekategorie e);

    @Query("SELECT * FROM incomeCategories_table")
    public List<Einnahmekategorie> getAllEinnahmekategorien();

}