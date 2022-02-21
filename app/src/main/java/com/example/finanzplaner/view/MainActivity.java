package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;

import com.example.finanzplaner.R;
import com.example.finanzplaner.db.DB;

import com.example.finanzplaner.model.finanzverwaltung.AusgabekategorieManager;
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


        //DB Setup
        DB.db = Room.databaseBuilder(getApplicationContext(), DB.class, "FinanzplanerDatabase").allowMainThreadQueries().build();
        DB.db.daoSetup();
        DB.einnahmekategorie.insertEinnahmekategorie(new Einnahmekategorie("BRiefe"));


        startActivity(new Intent(MainActivity.this,Dashboard.class).putExtra("Verwaltung", verwaltung));

    }



}