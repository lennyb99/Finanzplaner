package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;

import com.example.finanzplaner.R;
import com.example.finanzplaner.db.AppDatabase;
import com.example.finanzplaner.db.DbData;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DbData.db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();
        DbData.einnahmeDao = DbData.db.einnahmeDao();
        //DbData.einnahmeDao.deleteEinnahme(DbData.einnahmeDao.getEinnahme().get(0));
        //DbData.einnahmeDao.insertEinnahmen(new Einnahme("Auto", true));

        //Log.v("Test 1",DbData.einnahmeDao.getEinnahme().get(0).);



        startActivity(new Intent(MainActivity.this,Dashboard.class));

    }
}