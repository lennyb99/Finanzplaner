package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.finanzplaner.R;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;

import java.util.ArrayList;
import java.util.List;

public class DiagrammDetail extends AppCompatActivity {
    RecyclerView recyclerView;
    Verwaltung verwaltung = new Verwaltung();
    List<Einnahme> einnahmen = verwaltung.getEinnahmen();


    ArrayList<String> name;
    ArrayList<Float> betrag;
    ArrayList<String> datum;
    ArrayList<String> kategorie;
    ArrayList<Boolean> wiederkehrend;

    private void erstelleListen() {

       for (int i = 0; i < einnahmen.size(); i++) {
           name.add(einnahmen.get(i).getName());
        }
              for (int i = 0; i < einnahmen.size(); i++) {
           betrag.add(einnahmen.get(i).getBetrag());
        }
              for (int i = 0; i < einnahmen.size(); i++) {
           datum.add(einnahmen.get(i).getDatum());
        }
              for (int i = 0; i < einnahmen.size(); i++) {
           kategorie.add(einnahmen.get(i).getEinnahmekategorie());
        }
              for (int i = 0; i < einnahmen.size(); i++) {
           wiederkehrend.add(einnahmen.get(i).isWiederkehrend());
        }

    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        erstelleListen();
        MyAdapter adapter = new MyAdapter(name,betrag,datum,kategorie,wiederkehrend);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagrammdetail);
    }





}