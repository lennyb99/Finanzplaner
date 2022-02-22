package com.example.finanzplaner.controller;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;
import com.example.finanzplaner.view.EintraegeLoeschen;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EintraegeLoeschenController {

    EintraegeLoeschen eintraegeLoeschen;

    Verwaltung verwaltung;

    Spinner ausgabenSpinner;
    Spinner einnahmenSpinner;

    Button ausgabenButton;
    Button einnahmenButton;
    FloatingActionButton zurueckButton;


    public EintraegeLoeschenController(){}
    public EintraegeLoeschenController(EintraegeLoeschen eintraegeLoeschen){
        this.eintraegeLoeschen = eintraegeLoeschen;

        ausgabenSpinner = eintraegeLoeschen.getAusgabenSpinner();
        einnahmenSpinner = eintraegeLoeschen.getEinnahmenSpinner();
        ausgabenButton = eintraegeLoeschen.getAusgabenButton();
        einnahmenButton = eintraegeLoeschen.getEinnahmenButton();
        zurueckButton = eintraegeLoeschen.getZurueckButton();
        verwaltung = eintraegeLoeschen.getVerwaltung();

        zurueckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verwaltung.abmelden(eintraegeLoeschen);
                eintraegeLoeschen.finish();
            }
        });

        ausgabenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verwaltung.delAusgabe(getIdFromString((String)ausgabenSpinner.getSelectedItem()));
            }
        });

        einnahmenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verwaltung.delEinnahme(getIdFromString((String)einnahmenSpinner.getSelectedItem()));
            }
        });


    }

    public int getIdFromString(String str){
        String newId = "";
        for(int i = 0; i<str.length();i++){
            if(str.charAt(i) != ';'){
                newId += str.charAt(i);
            }else{
                break;
            }
        }
        return Integer.parseInt(newId);
    }

}
