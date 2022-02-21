package com.example.finanzplaner.controller;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;
import com.example.finanzplaner.view.EinnahmeView;
import com.example.finanzplaner.view.KategorieView;

import java.util.List;

public class EinnahmeController {

    private EinnahmeView einnahmeView;
    private Verwaltung verwaltung;

    private Button bestaetigung;
    private Button kategorieView;
    private EditText name;
    private EditText betrag;
    private EditText datum;
    private Spinner kategorieSpinner;

    private float betragWert;
    private String datumWert;
    private String nameWert;
    private String kategorieWert;

    public EinnahmeController(EinnahmeView einnahmeView, Verwaltung verwaltung){
        this.einnahmeView = einnahmeView;
        this.verwaltung = verwaltung;

        bestaetigung = einnahmeView.getBestaetigung();
        kategorieView = einnahmeView.getKategorieView();
        name = (EditText) einnahmeView.getName();
        betrag = (EditText) einnahmeView.getBetrag();
        datum = (EditText) einnahmeView.getDatum();
        kategorieSpinner = (Spinner) einnahmeView.getKategorienSpinner();

        bestaetigung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!betrag.getText().toString().equals("") && !name.getText().toString().equals("") && !datum.getText().toString().equals("") && !(kategorieSpinner==null)){
                    betragWert = Float.valueOf(betrag.getText().toString());
                    nameWert = name.getText().toString();
                    datumWert = datum.getText().toString();
                    kategorieWert = kategorieSpinner.getSelectedItem().toString();

                    verwaltung.addEinnahme(new Einnahme(nameWert, betragWert, false, verwaltung.findEinnahmekategorie(kategorieWert),datumWert));

                    einnahmeView.finish();
                }else if(!betrag.getText().toString().equals("") && !name.getText().toString().equals("") && datum.getText().toString().equals("") && !(kategorieSpinner==null)){
                    betragWert = Float.valueOf(betrag.getText().toString());
                    nameWert = name.getText().toString();
                    kategorieWert = kategorieSpinner.getSelectedItem().toString();

                    verwaltung.addEinnahme(new Einnahme(nameWert, betragWert, false, verwaltung.findEinnahmekategorie(kategorieWert)));

                    einnahmeView.finish();
                }else{
                    Toast.makeText(einnahmeView,"Bitte alle nötigen Felder ausfüllen", Toast.LENGTH_LONG).show();
                }
            }
        });

        kategorieView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                einnahmeView.startNewActivity(KategorieView.class);

            }
        });
    }



}
