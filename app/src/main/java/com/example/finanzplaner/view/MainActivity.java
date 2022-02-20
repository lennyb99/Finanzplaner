package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;

import com.example.finanzplaner.R;
import com.example.finanzplaner.db.AppDatabase;
import com.example.finanzplaner.db.DbData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DbData.db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();
        DbData.einnahmeDao = DbData.db.einnahmeDao();



        startActivity(new Intent(MainActivity.this,Dashboard.class));

    }
}