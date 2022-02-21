package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.EinnahmeController;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;

import java.util.List;

public class EinnahmeView extends AppCompatActivity {

    private EinnahmeController einnahmeController;
    private Verwaltung verwaltung;

    private List<String> kategorieItemsString;
    private List<Einnahmekategorie> kategorieItems;

    private Button bestaetigung;
    private EditText name;
    private EditText betrag;
    private EditText datum;
    private Button kategorieView;
    private Spinner kategorienSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einnahme);

        verwaltung = (Verwaltung) getIntent().getSerializableExtra("Verwaltung");

        kategorieItemsString = verwaltung.getEinnahmekategorieItemsString();
        kategorieItems = verwaltung.getEinnahmekategorieItems();

        bestaetigung = (Button) findViewById(R.id.bestaetigen);
        name = (EditText) findViewById(R.id.titel);
        betrag = (EditText) findViewById(R.id.betrag);
        datum = (EditText) findViewById(R.id.datum);
        kategorieView = (Button) findViewById(R.id.kategoriebutton);
        kategorienSpinner = (Spinner) findViewById(R.id.kategorie2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, kategorieItemsString);
        kategorienSpinner.setAdapter(adapter);

        einnahmeController = new EinnahmeController(this, kategorieItems, verwaltung);

    }

    public Spinner getKategorienSpinner(){
        return kategorienSpinner;
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

    public Button getKategorieView(){
        return kategorieView;
    }

    public void startNewActivity(Class dest){
        Log.v("mydebug", "debug1");
        startActivity(new Intent(EinnahmeView.this, dest).putExtra("Verwaltung", verwaltung));
        Log.v("mydebug", "debug1.2");
    }

}
