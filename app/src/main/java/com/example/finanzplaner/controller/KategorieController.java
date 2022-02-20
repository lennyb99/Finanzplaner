package com.example.finanzplaner.controller;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.finanzplaner.view.Kategorie;

public class KategorieController {

    private Kategorie kategorieView;

    private EditText einnahmeEingabe;
    private EditText ausgabeEingabe;

    private Button ausgabeButton;
    private Button eingabeButton;

    private Button beendenButton;

    public KategorieController(Kategorie kategorieView){

        this.kategorieView = kategorieView;

        einnahmeEingabe = kategorieView.getEinnahmeEingabe();
        ausgabeEingabe = kategorieView.getAusgabeEingabe();
        ausgabeButton = kategorieView.getAusgabeButton();
        eingabeButton = kategorieView.getEinnahmeButton();
        beendenButton = kategorieView.getBeendenButton();

        ausgabeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String neueKategorie = ausgabeEingabe.getText().toString();
                Log.v("mydebug", "Neue Ausgabekategorie hinzugefügt: "+neueKategorie);
                ausgabeEingabe.setText("");
            }
        });

        eingabeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String neueKategorie = einnahmeEingabe.getText().toString();
                Log.v("mydebug", "Neue Einnahmekategorie hinzugefügt: "+neueKategorie);
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
