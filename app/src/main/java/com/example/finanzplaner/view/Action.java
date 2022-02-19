package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.ActionController;

public class Action extends AppCompatActivity {

    ActionController actionController;

    Button ausgabeButton;
    Button einnahmeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        ausgabeButton = (Button) findViewById(R.id.ausgabe);
        einnahmeButton = (Button) findViewById(R.id.einnahme);

        actionController = new ActionController(this);

    }


    public void startNewActivity(Class dest){
        startActivity(new Intent(Action.this, dest));
    }

    public Button getAusgabeButton(){
        return ausgabeButton;
    }

    public Button getEinnahmeButton(){
        return einnahmeButton;
    }

}