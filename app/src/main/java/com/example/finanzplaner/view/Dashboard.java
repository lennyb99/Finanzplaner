package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.DashboardController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Dashboard extends AppCompatActivity implements IObserver{

    DashboardController dbController;
    FloatingActionButton eintraegeHinzufuegen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        eintraegeHinzufuegen = (FloatingActionButton) findViewById(R.id.hinzufuegen);

        dbController = new DashboardController(this);

    }

    @Override
    public void update() {

    }

    public FloatingActionButton getActionButton(){
        return eintraegeHinzufuegen;
    }

    public void startNewActivity(Class dest){
        startActivity(new Intent(Dashboard.this, dest));
    }



}