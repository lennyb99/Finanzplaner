package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.AusgabeController;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;

import java.util.List;

public class AusgabeView extends AppCompatActivity implements IObserver{

    private AusgabeController ausgabeController;
    private Verwaltung verwaltung;

    private List<String> kategorieItemsString;
    private List<Ausgabekategorie> kategorieItems;

    private Button bestaetigung;
    private EditText name;
    private EditText betrag;
    private EditText datum;
    private Button kategorieView;
    private Spinner kategorienSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausgabe);

        verwaltung = (Verwaltung) getIntent().getSerializableExtra("Verwaltung");

        kategorieItemsString = verwaltung.getAusgabekategorieItemsString();
        kategorieItems = verwaltung.getAusgabekategorieItems();

        bestaetigung = (Button) findViewById(R.id.bestaetigen);
        name = (EditText) findViewById(R.id.titel);
        betrag = (EditText) findViewById(R.id.betrag);
        datum = (EditText) findViewById(R.id.datum);
        kategorieView = (Button) findViewById(R.id.kategoriebutton2);
        kategorienSpinner = (Spinner) findViewById(R.id.kategorie);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, kategorieItemsString);
        kategorienSpinner.setAdapter(adapter);

        ausgabeController = new AusgabeController(this, kategorieItems, verwaltung);
    }

    public Spinner getKategorienSpinner() {
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
        startActivity(new Intent(AusgabeView.this, dest));
    }


    @Override
    public void update() {

    }
}
