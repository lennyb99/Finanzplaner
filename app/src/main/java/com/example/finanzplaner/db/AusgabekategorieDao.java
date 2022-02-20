package com.example.finanzplaner.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;

@Dao
public interface AusgabekategorieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAusgabekateogrie(Ausgabekategorie a);

    @Delete
    public void deleteAusgabekateogrie(Ausgabekategorie a);

    @Update
    public void updateAusgabekateogrie(Ausgabekategorie a);

}