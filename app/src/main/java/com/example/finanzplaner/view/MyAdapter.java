package com.example.finanzplaner.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finanzplaner.R;
import com.example.finanzplaner.model.finanzverwaltung.Ausgabe;
import com.example.finanzplaner.model.finanzverwaltung.Einnahme;
import com.example.finanzplaner.model.finanzverwaltung.Verwaltung;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyAdapter extends RecyclerView. Adapter<MyAdapter.ViewHolder> {


    Context context;
    Verwaltung verwaltung = new Verwaltung();
    ArrayList<String> name;
    private ArrayList<Float> betrag;
    private ArrayList<String> datum;
    private ArrayList<String> einnahmekategorie;
    private ArrayList<Boolean> wiederkehrend;
    public MyAdapter(ArrayList<String> name, ArrayList<Float> betrag, ArrayList<String> datum, ArrayList<String> einnahmekategorie, ArrayList<Boolean> wiederkehrend) {
        this.name = name;
        this.betrag = betrag;
        this.datum = datum;
        this.einnahmekategorie = einnahmekategorie;
        this.wiederkehrend = wiederkehrend;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }

    private void ertelleListen(List einnahmen) {


        List<Einnahme> name = verwaltung.getEinnahmen();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_diagrammdetail, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titelTW.setText(name.get(position));

        holder.betragTW.setText(String.valueOf(betrag.get(position)));
        holder.datumTW.setText(datum.get(position));
        holder.kategorieTW.setText(einnahmekategorie.get(position));
        //holder.setText(einnahmekategorie[position]);

    }

    @Override
    public int getItemCount() {

       return name.size();
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
