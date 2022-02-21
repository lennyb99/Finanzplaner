package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;

import com.example.finanzplaner.R;
import com.example.finanzplaner.db.DB;

import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instanziierung von Verwaltung
        Verwaltung verwaltung = new Verwaltung();

        //DB Setup
        DB.db = Room.databaseBuilder(getApplicationContext(), DB.class, "FinanzplanerDatabase").allowMainThreadQueries().build();
        DB.db.daoSetup();
        DB.einnahmekategorie.insertEinnahmekategorie(new Einnahmekategorie("BRiefe"));
        //DB-Insert-Tests
        DB.einnahme.insertEinnahme(new Einnahme("Kaffee",5,false,new Einnahmekategorie("Trinken")));
        DB.einnahme.insertEinnahme(new Einnahme("Wasser",23,false,new Einnahmekategorie("Essen")));
        DB.einnahme.insertEinnahme(new Einnahme("Kaffee",45,false,new Einnahmekategorie("Essen")));
        DB.einnahme.insertEinnahme(new Einnahme("Milch",1,false,new Einnahmekategorie("Essen")));
        DB.einnahme.insertEinnahme(new Einnahme("Kaffee",5532,false,new Einnahmekategorie("Trinken")));
        DB.einnahme.insertEinnahme(new Einnahme("Saft",12,false,new Einnahmekategorie("Essen")));
        DB.einnahme.insertEinnahme(new Einnahme("Kuchen",5,false,new Einnahmekategorie("Essen")));
        DB.einnahme.insertEinnahme(new Einnahme("Kaffee",5,false,new Einnahmekategorie("Essen")));
        DB.einnahme.insertEinnahme(new Einnahme("Äpfel",5,false,new Einnahmekategorie("Essen")));
        DB.einnahme.insertEinnahme(new Einnahme("Kaffee",5,false,new Einnahmekategorie("Essen")));

        startActivity(new Intent(MainActivity.this,Dashboard.class).putExtra("Verwaltung", verwaltung));

    }



}