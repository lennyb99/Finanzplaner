package com.example.finanzplaner.controller;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.finanzplaner.view.AusgabeView;
import com.example.finanzplaner.view.Dashboard;
import com.example.finanzplaner.view.EinnahmeView;
import com.example.finanzplaner.view.Kategorie;

public class EinnahmeController {

    private EinnahmeView einnahmeView;

    private Button bestaetigung;
    private Button kategorieView;
    private EditText name;
    private EditText betrag;
    private EditText datum;

    private float betragWert;
    private String datumWert;
    private String nameWert;


    public EinnahmeController(EinnahmeView einnahmeView){

        this.einnahmeView = einnahmeView;

        bestaetigung = einnahmeView.getBestaetigung();
        kategorieView = einnahmeView.getKategorieView();
        name = (EditText) einnahmeView.getName();
        betrag = (EditText) einnahmeView.getBetrag();
        datum = (EditText) einnahmeView.getDatum();

        bestaetigung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(betrag.getText().toString().equals("") || name.getText().toString().equals("")){

                }

                betragWert = Float.valueOf(betrag.getText().toString());
                nameWert = name.getText().toString();
                datumWert = datum.getText().toString();

                Log.v("mydebug",nameWert+betragWert+datumWert);

                //name.setText("");
                //datum.setText("");
                //betrag.setText("");

                einnahmeView.startNewActivity(Dashboard.class);
            }
        });

        kategorieView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                einnahmeView.startNewActivity(Kategorie.class);

            }
        });



    }


}
