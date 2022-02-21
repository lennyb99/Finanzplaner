package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.KategorieController;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;

public class KategorieView extends AppCompatActivity implements IObserver{

    private KategorieController katController;
    private Verwaltung verwaltung;

    private EditText einnahmeEingabe;
    private EditText ausgabeEingabe;

    private Button ausgabeButton;
    private Button einnahmeButton;

    private Button beendenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("mydebug", "debug1.5");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorie);
        Log.v("mydebug", "debug2");
        verwaltung = (Verwaltung) getIntent().getSerializableExtra("Verwaltung");
        Log.v("mydebug", "debug3");
        einnahmeEingabe = (EditText) findViewById(R.id.einnahmeeingabe);
        ausgabeEingabe = (EditText) findViewById(R.id.ausgabeeingabe);

        ausgabeButton = (Button) findViewById(R.id.eintragausgabe);
        einnahmeButton = (Button) findViewById(R.id.eintrageinnahme);

        beendenButton = findViewById(R.id.beenden);

        katController = new KategorieController(this, verwaltung);
        Log.v("mydebug", "debug4");
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


    @Override
    public void update() {

    }
}