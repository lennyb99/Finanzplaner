package com.example.finanzplaner.controller;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.finanzplaner.view.Action;
import com.example.finanzplaner.view.Dashboard;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardController implements Controller{


    private FloatingActionButton eintraegeHinzufuegen;
    private Dashboard dashboardView;

    public DashboardController(Dashboard dashboard){

        dashboardView = dashboard;
        eintraegeHinzufuegen = dashboardView.getActionButton();

        eintraegeHinzufuegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardView.startNewActivity(Action.class);
            }
        });

    }

    @Override
    public void schickeDatenAnModel() {

    }

}
