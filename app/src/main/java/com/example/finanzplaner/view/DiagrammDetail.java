package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.finanzplaner.R;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DiagrammDetail extends AppCompatActivity {
    RecyclerView recyclerView;
    Verwaltung verwaltung;
    List<Einnahme> einnahmen;
    MyAdapter adapter;
    ArrayList<String> name;
    ArrayList<Float> betrag;
    ArrayList<Calendar> datum;
    ArrayList<Einnahmekategorie> kategorie;
    ArrayList<Boolean> wiederkehrend;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagrammdetail);
        verwaltung = (Verwaltung) getIntent().getSerializableExtra("Verwaltung");
        einnahmen = new ArrayList<>();
        name = new ArrayList<>();
        betrag = new ArrayList<>();
        datum = new ArrayList<>();
        kategorie = new ArrayList<>();
        wiederkehrend = new ArrayList<>();

        einnahmen.add(new Einnahme("Apfel",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Birne",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kirschen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        einnahmen.add(new Einnahme("Kuchen",1,false,new Einnahmekategorie("Essen")));
        erstelleListen();

        adapter = new MyAdapter(this, name,betrag,datum,kategorie,wiederkehrend);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

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


}