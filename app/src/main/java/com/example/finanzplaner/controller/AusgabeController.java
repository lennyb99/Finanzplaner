package com.example.finanzplaner.controller;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finanzplaner.view.AusgabeView;
import com.example.finanzplaner.view.Dashboard;
import com.example.finanzplaner.view.Kategorie;

public class AusgabeController implements Controller{

    private AusgabeView ausgabeView;

    private Button bestaetigung;
    private Button kategorieView;
    private EditText name;
    private EditText betrag;
    private EditText datum;

    private float betragWert;
    private String datumWert;
    private String nameWert;

    public AusgabeController(AusgabeView aV){
        ausgabeView = aV;

        bestaetigung = ausgabeView.getBestaetigung();
        kategorieView = ausgabeView.getKategorieView();
        name = (EditText) ausgabeView.getName();
        betrag = (EditText) ausgabeView.getBetrag();
        datum = (EditText) ausgabeView.getDatum();


        bestaetigung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                betragWert = Float.valueOf(betrag.getText().toString());
                nameWert = name.getText().toString();
                datumWert = datum.getText().toString();

                Log.v("mydebug",nameWert+betragWert+datumWert);

                name.setText("");
                datum.setText("");
                betrag.setText("");

                ausgabeView.startNewActivity(Dashboard.class);
            }
        });

        kategorieView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ausgabeView.startNewActivity(Kategorie.class);
            }
        });

    }

    @Override
    public void schickeDatenAnModel() {

    }
}
