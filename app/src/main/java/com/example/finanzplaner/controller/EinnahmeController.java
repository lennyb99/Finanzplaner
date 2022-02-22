package com.example.finanzplaner.controller;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;
import com.example.finanzplaner.view.EinnahmeView;
import com.example.finanzplaner.view.EintraegeLoeschen;
import com.example.finanzplaner.view.KategorieView;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EinnahmeController implements Controller{

    private EinnahmeView einnahmeView;
    private Verwaltung verwaltung;

    private Button bestaetigung;
    private Button kategorieView;
    private Button zurueck;
    private EditText name;
    private EditText betrag;
    private EditText datum;
    private Spinner kategorieSpinner;

    private float betragWert;
    private String datumWert;
    private String nameWert;
    private String kategorieWert;

    public EinnahmeController(){}
    public EinnahmeController(EinnahmeView einnahmeView, Verwaltung verwaltung){
        this.einnahmeView = einnahmeView;
        this.verwaltung = verwaltung;

        bestaetigung = einnahmeView.getBestaetigung();
        kategorieView = einnahmeView.getKategorieView();
        zurueck = einnahmeView.getZurueck();
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
                    if(ueberpruefeDatumEingabe(datumWert)){
                        verwaltung.addEinnahme(new Einnahme(nameWert, betragWert, false, verwaltung.findEinnahmekategorie(kategorieWert),datumWert));

                        einnahmeView.finish();
                    }else {
                        Toast.makeText(einnahmeView, "Bitte korrektes Datum angeben", Toast.LENGTH_LONG).show();
                    }

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

        zurueck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                einnahmeView.finish();
            }
        });
    }

    public boolean ueberpruefeDatumEingabe(String datum){
        String regex = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(datum);

        return(matcher.matches());
    }


    @Override
    public void schickeDatenAnModel() {

    }
}
