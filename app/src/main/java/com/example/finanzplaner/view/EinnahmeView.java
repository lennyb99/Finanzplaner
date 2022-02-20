package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.EinnahmeController;


public class EinnahmeView extends AppCompatActivity {

    EinnahmeController einnahmeController;

    Button bestaetigung;
    EditText name;
    EditText betrag;
    EditText datum;
    private Button kategorieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einnahme);

        bestaetigung = (Button) findViewById(R.id.bestaetigen);
        name = (EditText) findViewById(R.id.titel);
        betrag = (EditText) findViewById(R.id.betrag);
        datum = (EditText) findViewById(R.id.datum);
        kategorieView = (Button) findViewById(R.id.kategoriebutton);

        einnahmeController = new EinnahmeController(this);

    }


    public Button getBestaetigung(){
        return bestaetigung;
    }

    public TextView getName(){
        return name;
    }

    public TextView getBetrag(){
        return betrag;
    }

    public TextView getDatum(){
        return datum;
    }

    public Button getKategorieView(){
        return kategorieView;
    }

    public void startNewActivity(Class dest){
        startActivity(new Intent(EinnahmeView.this, dest));
    }

}
