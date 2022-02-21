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

import java.util.List;


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

        //DB TESTS
        /*
        Einnahme e1 = new Einnahme("Gehalt1", 25.5f, false, new Einnahmekategorie("Job"));
        Einnahme e2 = new Einnahme("Gehalt2", 25.5f, false, new Einnahmekategorie("Job"));
        Einnahme e3 = new Einnahme("Gehalt3", 25.5f, false, new Einnahmekategorie("Job"));
        Einnahme e4 = new Einnahme("Gehalt4", 25.5f, false, new Einnahmekategorie("Job"));
        Log.v("EinnahmeTEST", e1.toString());
        Log.v("EinnahmeTEST", e2.toString());
        Log.v("EinnahmeTEST", e3.toString());
        Log.v("EinnahmeTEST", e4.toString());
        DB.einnahme.insertEinnahme(e1);
        DB.einnahme.insertEinnahme(e2);
        DB.einnahme.insertEinnahme(e3);
        DB.einnahme.insertEinnahme(e4);
        Log.v("EinnahmeTEST", e1.toString());
        Log.v("EinnahmeTEST", e2.toString());
        Log.v("EinnahmeTEST", e3.toString());
        Log.v("EinnahmeTEST", e4.toString());
        List<Einnahme> ld = DB.einnahme.getAllEinnahmen();
        ld.forEach(einnahme -> {
            Log.v("EinnahmeTEST2", einnahme.toString());

        });
        ld.forEach(einnahme -> {
            Log.v("EinnahmeTEST2", einnahme.toString());

        });
        */
        
        startActivity(new Intent(MainActivity.this,Dashboard.class).putExtra("Verwaltung", verwaltung));

    }



}