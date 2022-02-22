package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.finanzplaner.R;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Eintrag;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiagrammDetail extends AppCompatActivity implements IObserver{
    RecyclerView recyclerView;
    Verwaltung verwaltung;
    List<Eintrag> eintrag;
    List<Ausgabe> ausgaben;
    MyAdapter adapter;
    ArrayList<String> nameE;
    ArrayList<String> nameA;
    ArrayList<Float> betragE;
    ArrayList<Float> betragA;
    ArrayList<LocalDate> datumE;
    ArrayList<LocalDate> datumA;
    ArrayList<String> kategorieE;
    ArrayList<Ausgabekategorie> kategorieA;
    ArrayList<Boolean> wiederkehrendE;
    ArrayList<Boolean> wiederkehrendA;
    PieChart pieChart;
    PieData pieData;
    List<PieEntry> pieEntryList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagrammdetail);




        verwaltung = (Verwaltung) getIntent().getSerializableExtra("Verwaltung");
        verwaltung.anmelden(this);

        eintrag = (verwaltung.getEintraege());
        ausgaben = (verwaltung.getAusgaben());
        nameE = new ArrayList<>();
        nameA = new ArrayList<>();
        betragE = new ArrayList<>();
        betragA = new ArrayList<>();
        datumE = new ArrayList<>();
        datumA = new ArrayList<>();
        kategorieE = new ArrayList<>();
        kategorieA = new ArrayList<>();
        wiederkehrendE = new ArrayList<>();
        wiederkehrendA = new ArrayList<>();

        erstelleListenE();


        adapter = new MyAdapter(this,nameE,betragE,datumE,kategorieE,wiederkehrendE);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pieChart = findViewById(R.id.pieChart2);
        pieChart.setUsePercentValues(true);

       // erstellePieChartE();
        //erstellePieChartA();

        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"Ausgabe");
        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);

        pieChart.invalidate();

    }

    private void erstelleListenE() {
        if(nameE.size()!=0) {
            nameE.clear();
            betragE.clear();
            datumE.clear();
            kategorieE.clear();
            wiederkehrendE.clear();
        }
        for (int i = 0; i < eintrag.size(); i++) {
            nameE.add(eintrag.get(i).getName());
        }
        for (int i = 0; i < eintrag.size(); i++) {
            if(eintrag.get(i).getClass() == Einnahme.class) {
                betragE.add(eintrag.get(i).getBetrag());
            }
            else if(eintrag.get(i).getClass() == Ausgabe.class){
                betragE.add(eintrag.get(i).getBetrag()*-1);

            }
        }
        for (int i = 0; i < eintrag.size(); i++) {
            datumE.add(eintrag.get(i).getDatum());
        }
        for (int i = 0; i < eintrag.size(); i++) {

            if(eintrag.get(i).getClass() == Einnahme.class){
                Einnahme einnahmenTemp = (Einnahme) eintrag.get(i);
                kategorieE.add(String.valueOf(einnahmenTemp.getEinnahmekategorie().getName()));
                Log.v("Else-Block","Einnahme");

            }
            else if(eintrag.get(i).getClass() == Ausgabe.class){
                Ausgabe ausgabenTemp = (Ausgabe) eintrag.get(i);
                kategorieE.add(String.valueOf(ausgabenTemp.getAusgabekategorie().getName()));
                Log.v("Else-Block","Ausgabe");

            }
            else{
                Log.v("Else-Block","34");
            }

        }
        for (int i = 0; i < eintrag.size(); i++) {
            wiederkehrendE.add(eintrag.get(i).isWiederkehrend());
        }
    }

    private void erstellePieChartE(){

        for (int i = 0; i < eintrag.size(); i++) {
            pieEntryList.add(new PieEntry( betragE.get(i),nameE.get(i)));

        }

    }
    private void erstellePieChartA(){

        for (int i = 0; i < ausgaben.size(); i++) {
            pieEntryList.add(new PieEntry( betragA.get(i),nameA.get(i)));

        }

    }


    @Override
    public void update() {
        eintrag = verwaltung.getEintraege();
        // Einnahmen wurde überschrieben. Der RecyclerView kann jetzt nochmal neu aufgebaut / aktualisiert werden

    }
}