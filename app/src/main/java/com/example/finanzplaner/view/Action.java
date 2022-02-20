package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.ActionController;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;

public class Action extends AppCompatActivity {

    Verwaltung verwaltung;

    ActionController actionController;

    Button ausgabeButton;
    Button einnahmeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        verwaltung = (Verwaltung) getIntent().getSerializableExtra("Verwaltung");

        ausgabeButton = (Button) findViewById(R.id.ausgabe);
        einnahmeButton = (Button) findViewById(R.id.einnahme);

        actionController = new ActionController(this);

    }


    public void startNewActivity(Class dest){
        startActivity(new Intent(Action.this, dest).putExtra("Verwaltung", verwaltung));
    }

    public Button getAusgabeButton(){
        return ausgabeButton;
    }

    public Button getEinnahmeButton(){
        return einnahmeButton;
    }

}