package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.KategorieController;

public class Kategorie extends AppCompatActivity {

    private KategorieController katController;

    private EditText einnahmeEingabe;
    private EditText ausgabeEingabe;

    private Button ausgabeButton;
    private Button einnahmeButton;

    private Button beendenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorie);

        einnahmeEingabe = (EditText) findViewById(R.id.einnahmeeingabe);
        ausgabeEingabe = (EditText) findViewById(R.id.ausgabeeingabe);

        ausgabeButton = (Button) findViewById(R.id.eintragausgabe);
        einnahmeButton = (Button) findViewById(R.id.eintrageinnahme);

        beendenButton = findViewById(R.id.beenden);

        katController = new KategorieController(this);

    }


    public Button getEinnahmeButton(){
        return einnahmeButton;
    }
    public Button getAusgabeButton(){
        return ausgabeButton;
    }
    public Button getBeendenButton(){
        return beendenButton;
    }
    public EditText getEinnahmeEingabe(){
        return einnahmeEingabe;
    }
    public EditText getAusgabeEingabe(){
        return ausgabeEingabe;
    }



}