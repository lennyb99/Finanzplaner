package com.example.finanzplaner.db.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;

import java.util.List;

@Dao
public interface AusgabekategorieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAusgabekategorie(Ausgabekategorie a);

    @Delete
    public void deleteAusgabekateogrie(Ausgabekategorie a);

    @Query("DELETE FROM expenseCateogries_table WHERE name = :name")
    public void deleteAusgabekategorie(String name);

    @Update
    public void updateAusgabekateogrie(Ausgabekategorie a);

    @Query("SELECT * FROM expenseCateogries_table")
    public List<Ausgabekategorie> getAllAusgabekategorien();

}