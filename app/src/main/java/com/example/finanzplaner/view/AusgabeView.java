package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.AusgabeController;

public class AusgabeView extends AppCompatActivity {

    AusgabeController ausgabeController;

    Button bestaetigung;
    EditText name;
    EditText betrag;
    EditText datum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausgabe);

        bestaetigung = (Button) findViewById(R.id.bestaetigen);
        name = (EditText) findViewById(R.id.titel);
        betrag = (EditText) findViewById(R.id.betrag);
        datum = (EditText) findViewById(R.id.date);

        ausgabeController = new AusgabeController(this);
    }

    public Button getBestaetigung(){
        return bestaetigung;
    }

    public TextView getName(){
        return name;
    }

    public TextView getBetrag(){
        return betrag;
    }

    public TextView getDatum(){
        return datum;
    }

    public void startNewActivity(Class dest){
        startActivity(new Intent(AusgabeView.this, dest));
    }





}