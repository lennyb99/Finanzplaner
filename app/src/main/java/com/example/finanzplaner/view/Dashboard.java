package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.finanzplaner.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity implements IObserver{

    PieChart pieChart;
    PieData pieData;
    List<PieEntry> pieEntryList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        pieChart = findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(true);
        pieEntryList.add(new PieEntry(10,"India"));
        pieEntryList.add(new PieEntry(5,"US"));
        pieEntryList.add(new PieEntry(7,"UK"));
        pieEntryList.add(new PieEntry(3,"NZ"));
        PieDataSet pieDataSet = new PieDataSet(pieEntryList,"country");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    @Override
    public void update() {

    }
}