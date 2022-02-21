package com.example.finanzplaner.controller;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;
import com.example.finanzplaner.view.KategorieView;

public class KategorieController {

    private KategorieView kategorieView;
    private Verwaltung verwaltung;

    private EditText einnahmeEingabe;
    private EditText ausgabeEingabe;

    private Button ausgabeButton;
    private Button eingabeButton;

    private Button beendenButton;

    public KategorieController(KategorieView kategorieView, Verwaltung verwaltung){

        this.kategorieView = kategorieView;
        this.verwaltung = verwaltung;

        einnahmeEingabe = kategorieView.getEinnahmeEingabe();
        ausgabeEingabe = kategorieView.getAusgabeEingabe();
        ausgabeButton = kategorieView.getAusgabeButton();
        eingabeButton = kategorieView.getEinnahmeButton();
        beendenButton = kategorieView.getBeendenButton();

        ausgabeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String neueKategorie = ausgabeEingabe.getText().toString();
                Log.v("mydebug", "Neue Ausgabekategorie registriert "+neueKategorie);
                verwaltung.addAusgabekategorie(new Ausgabekategorie(neueKategorie));
                ausgabeEingabe.setText("");
            }
        });

        eingabeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String neueKategorie = einnahmeEingabe.getText().toString();
                Log.v("mydebug", "Neue Einnahmekategorie registriert: "+neueKategorie);
                verwaltung.addEinnahmekategorie(new Einnahmekategorie(neueKategorie));
                einnahmeEingabe.setText("");
            }
        });

        beendenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kategorieView.finish();
            }
        });

    }

}
