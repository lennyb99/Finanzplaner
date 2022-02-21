package com.example.finanzplaner.controller;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;
import com.example.finanzplaner.view.AusgabeView;
import com.example.finanzplaner.view.Dashboard;
import com.example.finanzplaner.view.KategorieView;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AusgabeController implements Controller{

    private AusgabeView ausgabeView;
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

    public AusgabeController(AusgabeView aV, Verwaltung verwaltung){
        ausgabeView = aV;
        this.verwaltung= verwaltung;

        bestaetigung = ausgabeView.getBestaetigung();
        kategorieView = ausgabeView.getKategorieView();
        zurueck = ausgabeView.getZurueck();
        name = (EditText) ausgabeView.getName();
        betrag = (EditText) ausgabeView.getBetrag();
        datum = (EditText) ausgabeView.getDatum();
        kategorieSpinner = (Spinner) ausgabeView.getKategorienSpinner();

        bestaetigung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!betrag.getText().toString().equals("") && !name.getText().toString().equals("") && !datum.getText().toString().equals("") && !(kategorieSpinner==null)){
                    betragWert = Float.valueOf(betrag.getText().toString());
                    nameWert = name.getText().toString();
                    datumWert = datum.getText().toString();
                    kategorieWert = kategorieSpinner.getSelectedItem().toString();
                    if(ueberpruefeDatumEingabe(datumWert)){
                        verwaltung.addAusgabe(new Ausgabe(nameWert, betragWert,false, verwaltung.findAusgabekategorie(kategorieWert), datumWert));

                        ausgabeView.finish();
                    }else {
                        Toast.makeText(ausgabeView, "Bitte korrektes Datum angeben", Toast.LENGTH_LONG).show();
                    }
                }else if(!betrag.getText().toString().equals("") && !name.getText().toString().equals("") && datum.getText().toString().equals("") && !(kategorieSpinner==null)){
                    betragWert = Float.valueOf(betrag.getText().toString());
                    nameWert = name.getText().toString();
                    kategorieWert = kategorieSpinner.getSelectedItem().toString();


                    verwaltung.addAusgabe(new Ausgabe(nameWert, betragWert,false, verwaltung.findAusgabekategorie(kategorieWert)));

                    ausgabeView.finish();
                }else{
                    Toast.makeText(ausgabeView,"Bitte alle nötigen Felder ausfüllen", Toast.LENGTH_LONG).show();
                }


            }
        });

        kategorieView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ausgabeView.startNewActivity(KategorieView.class);
            }
        });

        zurueck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ausgabeView.finish();
            }
        });


    }

    private boolean ueberpruefeDatumEingabe(String datum){
        String regex = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(datum);

        return(matcher.matches());
    }

    @Override
    public void schickeDatenAnModel() {

    }
}
