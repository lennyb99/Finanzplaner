package com.example.finanzplaner.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.finanzplaner.R;

public class DiagrammDetail extends AppCompatActivity {
    RecyclerView recyclerView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        recyclerView = findViewById(R.id.legendeDiagramm);
        MyAdapter myAdapter = new MyAdapter()
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagrammdetail);
    }





}