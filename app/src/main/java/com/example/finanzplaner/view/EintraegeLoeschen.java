package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.EintraegeLoeschenController;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class EintraegeLoeschen extends AppCompatActivity implements IObserver{

    Verwaltung verwaltung;

    List<Einnahme> einnahmeList;
    List<Ausgabe> ausgabeList;
    List<String> printListEinnahme;
    List<String> printListAusgabe;

    Spinner ausgabenSpinner;
    Spinner einnahmenSpinner;

    Button ausgabenButton;
    Button einnahmenButton;

    FloatingActionButton zurueckButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eintraege_loeschen);

        printListAusgabe = new ArrayList<>();
        printListEinnahme = new ArrayList<>();
        verwaltung = (Verwaltung)getIntent().getSerializableExtra("Verwaltung");
        verwaltung.anmelden(this);




        ausgabenSpinner = findViewById(R.id.ausgabenspinner);
        einnahmenSpinner = findViewById(R.id.einnahmenspinner);
        ausgabenButton = findViewById(R.id.ausgabebutton);
        einnahmenButton = findViewById(R.id.einnahmebutton);
        zurueckButton = findViewById(R.id.abbruch2);

        update();



        EintraegeLoeschenController eintraegeLoeschenController = new EintraegeLoeschenController(this);

    }

    public Spinner getAusgabenSpinner() {
        return ausgabenSpinner;
    }

    public Spinner getEinnahmenSpinner() {
        return einnahmenSpinner;
    }

    public Button getAusgabenButton() {
        return ausgabenButton;
    }

    public Button getEinnahmenButton() {
        return einnahmenButton;
    }

    public FloatingActionButton getZurueckButton() {
        return zurueckButton;
    }

    public Verwaltung getVerwaltung() {
        return verwaltung;
    }

    @Override
    public void update() {
        einnahmeList = verwaltung.getEinnahmen();
        ausgabeList = verwaltung.getAusgaben();

        printListEinnahme.clear();
        printListAusgabe.clear();

        for (Einnahme einnahme: einnahmeList ) {
            printListEinnahme.add(einnahme.getId()+ ";" + einnahme.getName() + "; " +einnahme.getBetrag()+ "; "+einnahme.getEinnahmekategorie().getName());
        }

        for (Ausgabe ausgabe: ausgabeList ) {
            printListAusgabe.add(ausgabe.getId()+ ";"+ ausgabe.getName() + "; " +ausgabe.getBetrag()+ "; "+ausgabe.getAusgabekategorie().getName());
        }

        ArrayAdapter<String> ausgabenadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, printListAusgabe);
        ausgabenSpinner.setAdapter(ausgabenadapter);

        ArrayAdapter<String> einnahmenadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, printListEinnahme);
        einnahmenSpinner.setAdapter(einnahmenadapter);


    }
}