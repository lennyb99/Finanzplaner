package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.finanzplaner.R;
import com.example.finanzplaner.db.AppDatabase;
import com.example.finanzplaner.db.EinnahmeDao;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();
        EinnahmeDao ed = db.einnahmeDao();
        ed.insertEinnahmen(new Einnahme("Zeitung", true));

    }
}