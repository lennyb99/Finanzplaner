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
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DiagrammDetail extends AppCompatActivity implements IObserver{
    RecyclerView recyclerView;
    Verwaltung verwaltung;
    List<Einnahme> einnahmen;
    MyAdapter adapter;
    ArrayList<String> name;
    ArrayList<Float> betrag;
    ArrayList<LocalDate> datum;
    ArrayList<Einnahmekategorie> kategorie;
    ArrayList<Boolean> wiederkehrend;
    PieChart pieChart;
    PieData pieData;
    List<PieEntry> pieEntryList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagrammdetail);




        verwaltung = (Verwaltung) getIntent().getSerializableExtra("Verwaltung");
        verwaltung.anmelden(this);

        einnahmen = (verwaltung.getEinnahmen());
        name = new ArrayList<>();
        betrag = new ArrayList<>();
        datum = new ArrayList<>();
        kategorie = new ArrayList<>();
        wiederkehrend = new ArrayList<>();

        erstelleListen();


        adapter = new MyAdapter(this, name,betrag,datum,kategorie,wiederkehrend);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pieChart = findViewById(R.id.pieChart2);
        pieChart.setUsePercentValues(true);

        erstellePieChart();
        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"Ausgabe");
        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);

        pieChart.invalidate();

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

    private void erstellePieChart(){

        for (int i = 0; i < einnahmen.size(); i++) {
            pieEntryList.add(new PieEntry(betrag.get(i),name.get(i)));

        }

    }


    @Override
    public void update() {
        einnahmen = verwaltung.getEinnahmen();
        // Einnahmen wurde überschrieben. Der RecyclerView kann jetzt nochmal neu aufgebaut / aktualisiert werden

    }
}