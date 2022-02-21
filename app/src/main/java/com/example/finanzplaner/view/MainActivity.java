package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;

import com.example.finanzplaner.R;
import com.example.finanzplaner.db.DB;

import com.example.finanzplaner.model.finanzverwaltung.AusgabeManager;
import com.example.finanzplaner.model.finanzverwaltung.AusgabekategorieManager;
import com.example.finanzplaner.model.finanzverwaltung.EinnahmeManager;
import com.example.finanzplaner.model.finanzverwaltung.EinnahmekategorieManager;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;
import com.example.finanzplaner.model.finanzverwaltung.ViewManager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instanziierung von Verwaltung

        Verwaltung verwaltung = new Verwaltung();
        ViewManager viewManager = new ViewManager();
        EinnahmekategorieManager einnahmekategorieManager = new EinnahmekategorieManager();
        AusgabekategorieManager ausgabekategorieManager = new AusgabekategorieManager();
        AusgabeManager ausgabeManager = new AusgabeManager();
        EinnahmeManager einnahmeManager = new EinnahmeManager();


        //DB Setup
        DB.db = Room.databaseBuilder(getApplicationContext(), DB.class, "FinanzplanerDatabase").allowMainThreadQueries().build();
        DB.db.daoSetup();


        startActivity(new Intent(MainActivity.this,Dashboard.class).putExtra("Verwaltung", verwaltung));

    }



}