package com.example.finanzplaner.controller;

import android.view.View;
import android.widget.Button;

import com.example.finanzplaner.view.Action;
import com.example.finanzplaner.view.AusgabeView;
import com.example.finanzplaner.view.EinnahmeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActionController {

    Action actionView;

    FloatingActionButton ausgabeButton;
    FloatingActionButton einnahmeButton;
    FloatingActionButton zurueckButton;

    public ActionController(Action action){

        actionView = action;

        ausgabeButton = actionView.getAusgabeButton();
        einnahmeButton = actionView.getEinnahmeButton();
        zurueckButton = actionView.getZurueckButton();

        ausgabeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionView.startNewActivity(AusgabeView.class);
            }
        });

        einnahmeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionView.startNewActivity(EinnahmeView.class);
            }
        });
        zurueckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionView.finish();
            }
        });

    }

}
