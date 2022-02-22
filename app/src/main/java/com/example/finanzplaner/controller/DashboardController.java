package com.example.finanzplaner.controller;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.finanzplaner.view.Action;
import com.example.finanzplaner.view.Dashboard;
import com.example.finanzplaner.view.DiagrammDetail;
import com.example.finanzplaner.view.EintraegeLoeschen;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardController implements Controller{


    private FloatingActionButton eintraegeHinzufuegen;
    private FloatingActionButton diagrammDetailButton;
    private FloatingActionButton eintraegeLöschen;
    private Dashboard dashboardView;

    public DashboardController(Dashboard dashboard){

        dashboardView = dashboard;
        eintraegeHinzufuegen = dashboardView.getActionButton();
        diagrammDetailButton = dashboardView.getDiagrammDetailButton();
        eintraegeLöschen = dashboardView.getEintraegeLoeschenButton();

        eintraegeHinzufuegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardView.startNewActivity(Action.class);
            }
        });

        diagrammDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardView.startNewActivity(DiagrammDetail.class);
            }
        });

        eintraegeLöschen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardView.startNewActivity(EintraegeLoeschen.class);
            }
        });

    }

    @Override
    public void schickeDatenAnModel() {

    }

}
