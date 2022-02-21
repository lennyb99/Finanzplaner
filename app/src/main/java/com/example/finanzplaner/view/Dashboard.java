package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.DashboardController;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity implements IObserver{

    private Verwaltung verwaltung;

    private List<Ausgabe> ausgabenList;

    PieChart pieChart;
    PieData pieData;
    List<PieEntry> pieEntryList = new ArrayList<>();
    DashboardController dbController;
    FloatingActionButton eintraegeHinzufuegen;
    FloatingActionButton diagrammDetailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        verwaltung = (Verwaltung) getIntent().getSerializableExtra("Verwaltung");
        verwaltung.anmelden(this);

        eintraegeHinzufuegen = (FloatingActionButton) findViewById(R.id.hinzufuegen);
        diagrammDetailButton = (FloatingActionButton) findViewById(R.id.diagrammdetail_button);
        dbController = new DashboardController(this);

        pieChart = findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(true);
        pieEntryList.add(new PieEntry(10,"Tesla"));
        pieEntryList.add(new PieEntry(5,"Essen"));
        pieEntryList.add(new PieEntry(7,"Miete"));
        pieEntryList.add(new PieEntry(3,"Hoes"));
        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"Ausgaben");
        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
        pieChart.getDescription().setEnabled(false);
    }


    public FloatingActionButton getActionButton(){
        return eintraegeHinzufuegen;
    }
    public FloatingActionButton getDiagrammDetailButton(){return diagrammDetailButton; }

    public void startNewActivity(Class dest){
        startActivity(new Intent(Dashboard.this, dest).putExtra("Verwaltung", verwaltung));
    }

    @Override
    public void update() {
        ausgabenList = verwaltung.getAusgaben();
        // Einnahmen wurde überschrieben. Der PieChart kann jetzt nochmal neu aufgebaut / aktualisiert werden

    }

}