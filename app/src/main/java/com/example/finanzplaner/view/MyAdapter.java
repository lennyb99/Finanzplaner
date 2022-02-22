package com.example.finanzplaner.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finanzplaner.R;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    Context context;
    //Arrays um aus der Liste von Ojekten mehrere Listen mit den Entsprechenden Attributen zu erstellen
    ArrayList<String> nameE;
    private ArrayList<Float> betragE;
    private ArrayList<LocalDate> datumE;
    private ArrayList<String> einnahmekategorie;
    private ArrayList<Boolean> wiederkehrendE;


    //Konstruktor


    public MyAdapter(Context ct,ArrayList<String> nameE, ArrayList<Float> betragE, ArrayList<LocalDate> datumE, ArrayList<String> einnahmekategorie, ArrayList<Boolean> wiederkehrendE){
        this.context = ct;
        this.nameE = nameE;
        this.betragE = betragE;
        this.datumE = datumE;
        this.einnahmekategorie = einnahmekategorie;
        this.wiederkehrendE = wiederkehrendE;

    }
    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.diagrammdetail_row, parent, false);
        return new ViewHolder(view);
    }




    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }

    @Override
    public int getItemCount() { return nameE.size(); }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titelTW.setText(nameE.get(position));
        holder.betragTW.setText(String.valueOf(betragE.get(position)));
        holder.datumTW.setText(datumE.get(position).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        holder.kategorieTW.setText(einnahmekategorie.get(position));
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titelTW, kategorieTW, datumTW, betragTW;
        ImageView thumbnailTW;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titelTW = itemView.findViewById(R.id.RvTitel);
            kategorieTW = itemView.findViewById(R.id.RvKategorie);
            datumTW = itemView.findViewById(R.id.RvDatum);
            betragTW = itemView.findViewById(R.id.RvBetrag);
            thumbnailTW = itemView.findViewById(R.id.RvThumbnail);
        }
    }


}
