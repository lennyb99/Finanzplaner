package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.ActionController;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Action extends AppCompatActivity {

    Verwaltung verwaltung;

    ActionController actionController;

    FloatingActionButton ausgabeButton;
    FloatingActionButton einnahmeButton;
    FloatingActionButton zurueckButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        verwaltung = (Verwaltung) getIntent().getSerializableExtra("Verwaltung");

        ausgabeButton = (FloatingActionButton) findViewById(R.id.ausgabe);
        einnahmeButton = (FloatingActionButton) findViewById(R.id.einnahme);
        zurueckButton = (FloatingActionButton) findViewById(R.id.abbruch);

        actionController = new ActionController(this);

    }


    public void startNewActivity(Class dest){
        startActivity(new Intent(Action.this, dest).putExtra("Verwaltung", verwaltung));
    }

    public FloatingActionButton getAusgabeButton(){
        return ausgabeButton;
    }

    public FloatingActionButton getZurueckButton() {
        return zurueckButton;
    }

    public FloatingActionButton getEinnahmeButton(){
        return einnahmeButton;
    }

}