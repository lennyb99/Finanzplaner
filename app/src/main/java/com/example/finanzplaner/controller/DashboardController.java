package com.example.finanzplaner.controller;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.finanzplaner.view.Action;
import com.example.finanzplaner.view.Dashboard;
import com.example.finanzplaner.view.DiagrammDetail;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardController implements Controller{


    private FloatingActionButton eintraegeHinzufuegen;
    private FloatingActionButton diagrammDetailButton;
    private Dashboard dashboardView;

    public DashboardController(Dashboard dashboard){

        dashboardView = dashboard;
        eintraegeHinzufuegen = dashboardView.getActionButton();
        diagrammDetailButton = dashboardView.getDiagrammDetailButton();

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

    }

    @Override
    public void schickeDatenAnModel() {

    }

}
