package com.example.finanzplaner.controller;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;
import com.example.finanzplaner.view.AusgabeView;
import com.example.finanzplaner.view.Dashboard;
import com.example.finanzplaner.view.KategorieView;

import java.util.List;

public class AusgabeController implements Controller{

    private AusgabeView ausgabeView;
    private Verwaltung verwaltung;

    private Button bestaetigung;
    private Button kategorieView;
    private EditText name;
    private EditText betrag;
    private EditText datum;
    private Spinner kategorieSpinner;

    List<Ausgabekategorie> ausgabekategorieItems;

    private float betragWert;
    private String datumWert;
    private String nameWert;
    private String kategorieWert;

    public AusgabeController(AusgabeView aV, List<Ausgabekategorie> ausgabekategorien, Verwaltung verwaltung){
        ausgabeView = aV;
        ausgabekategorieItems = ausgabekategorien;
        this.verwaltung= verwaltung;

        bestaetigung = ausgabeView.getBestaetigung();
        kategorieView = ausgabeView.getKategorieView();
        name = (EditText) ausgabeView.getName();
        betrag = (EditText) ausgabeView.getBetrag();
        datum = (EditText) ausgabeView.getDatum();
        kategorieSpinner = (Spinner) ausgabeView.getKategorienSpinner();


        bestaetigung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                betragWert = Float.valueOf(betrag.getText().toString());
                nameWert = name.getText().toString();
                datumWert = datum.getText().toString();
                kategorieWert = kategorieSpinner.getSelectedItem().toString();


                verwaltung.addAusgabe(new Ausgabe(nameWert, betragWert,false, verwaltung.findAusgabekategorie(kategorieWert)));




                //ausgabeView.startNewActivit+y(Dashboard.class);
                ausgabeView.finish();
            }
        });

        kategorieView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ausgabeView.startNewActivity(KategorieView.class);
            }
        });

    }

    @Override
    public void schickeDatenAnModel() {

    }
}
