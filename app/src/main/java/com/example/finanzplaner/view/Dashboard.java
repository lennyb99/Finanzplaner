package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.finanzplaner.R;

public class Dashboard extends AppCompatActivity implements IObserver{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    @Override
    public void update() {

    }
}