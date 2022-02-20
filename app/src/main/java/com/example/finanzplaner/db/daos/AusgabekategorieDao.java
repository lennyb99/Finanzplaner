package com.example.finanzplaner.db.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;

@Dao
public interface AusgabekategorieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAusgabekateogrie(Ausgabekategorie a);

    @Delete
    public void deleteAusgabekateogrie(Ausgabekategorie a);

    @Update
    public void updateAusgabekateogrie(Ausgabekategorie a);

}