package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;


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
        DB.db.initHighesIds();

        //DB TESTS
        DB.einnahmekategorie.insertEinnahmekategorie(new Einnahmekategorie("Einahmekategorie1"));
        DB.einnahmekategorie.insertEinnahmekategorie(new Einnahmekategorie("Einahmekategorie2"));
        DB.einnahmekategorie.insertEinnahmekategorie(new Einnahmekategorie("Einahmekategorie3"));
        DB.einnahmekategorie.insertEinnahmekategorie(new Einnahmekategorie("Einahmekategorie4"));
        DB.ausgabekategorie.insertAusgabekategorie(new Ausgabekategorie("Ausgabekategorie1"));
        DB.ausgabekategorie.insertAusgabekategorie(new Ausgabekategorie("Ausgabekategorie2"));
        DB.ausgabekategorie.insertAusgabekategorie(new Ausgabekategorie("Ausgabekategorie3"));
        DB.ausgabekategorie.insertAusgabekategorie(new Ausgabekategorie("Ausgabekategorie4"));

        DB.einnahme.insertEinnahme(new Einnahme("Job1", 235.2f, false, new Einnahmekategorie("Einahmekategorie1")));
        DB.einnahme.insertEinnahme(new Einnahme("Job2", 235.2f, false, new Einnahmekategorie("Einahmekategorie2")));
        DB.einnahme.insertEinnahme(new Einnahme("Job3", 235.2f, false, new Einnahmekategorie("Einahmekategorie3")));

        DB.ausgabe.insertAusgabe(new Ausgabe("AKs1", 323.4f, false, new Ausgabekategorie("Ausgabekategorie1")));
        DB.ausgabe.insertAusgabe(new Ausgabe("AKs2", 323.4f, false, new Ausgabekategorie("Ausgabekategorie2")));
        DB.ausgabe.insertAusgabe(new Ausgabe("AKs3", 32.4f, false, new Ausgabekategorie("Ausgabekategorie3")));

        startActivity(new Intent(MainActivity.this,Dashboard.class).putExtra("Verwaltung", verwaltung));

    }



}