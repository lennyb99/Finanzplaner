package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.finanzplaner.R;
import com.example.finanzplaner.controller.DashboardController;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dashboard extends AppCompatActivity implements IObserver{

    private Verwaltung verwaltung;

    private List<Ausgabe> ausgabenList;

    PieChart pieChart;
    PieData pieData;
    List<PieEntry> pieEntryList = new ArrayList<>();
    List<Einnahme> einnahmen;
    DashboardController dbController;
    FloatingActionButton eintraegeHinzufuegen;
    FloatingActionButton diagrammDetailButton;
    FloatingActionButton eintraegeLoeschenButton;
    ArrayList<String> name;
    ArrayList<Float> betrag;
    ArrayList<LocalDate> datum;
    ArrayList<Einnahmekategorie> kategorie;
    ArrayList<Boolean> wiederkehrend;
    Map<String,Float> ausgabeGewichtungen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        verwaltung = (Verwaltung) getIntent().getSerializableExtra("Verwaltung");
        verwaltung.anmelden(this);
        ausgabeGewichtungen = verwaltung.getKategoriegewichtungen();

        einnahmen = (verwaltung.getEinnahmen());
        name = new ArrayList<>();
        betrag = new ArrayList<>();
        datum = new ArrayList<>();
        kategorie = new ArrayList<>();
        wiederkehrend = new ArrayList<>();
        erstelleListen();

        eintraegeHinzufuegen = (FloatingActionButton) findViewById(R.id.hinzufuegen);
        diagrammDetailButton = (FloatingActionButton) findViewById(R.id.diagrammdetail_button);
        eintraegeLoeschenButton = (FloatingActionButton) findViewById(R.id.loeschen);
        dbController = new DashboardController(this);

        pieChart = findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(true);
        erstellePieChartE();
        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"");
        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.invalidate();


    }

    private void erstelleListen() {
        if(name.size()!=0) {
            name.clear();
            betrag.clear();
            datum.clear();
            kategorie.clear();
            wiederkehrend.clear();
        }
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

    private void erstellePieChartE(){
        pieEntryList.clear();
        for (String ak :ausgabeGewichtungen.keySet()) {
            pieEntryList.add(new PieEntry(ausgabeGewichtungen.get(ak),ak));


        }

    }


    public FloatingActionButton getActionButton(){
        return eintraegeHinzufuegen;
    }
    public FloatingActionButton getDiagrammDetailButton(){return diagrammDetailButton; }
    public FloatingActionButton getEintraegeLoeschenButton(){return eintraegeLoeschenButton;}

    public void startNewActivity(Class dest){
        startActivity(new Intent(Dashboard.this, dest).putExtra("Verwaltung", verwaltung));
    }

    @Override
    public void update() {
        einnahmen = verwaltung.getEinnahmen();
        name = new ArrayList<>();
        betrag = new ArrayList<>();
        datum = new ArrayList<>();
        kategorie = new ArrayList<>();
        wiederkehrend = new ArrayList<>();
        ausgabeGewichtungen = verwaltung.getKategoriegewichtungen();
        erstelleListen();
        erstellePieChartE();
        pieChart.setData(pieData);
        pieChart.invalidate();
        // Einnahmen wurde überschrieben. Der PieChart kann jetzt nochmal neu aufgebaut / aktualisiert werden

    }

}
