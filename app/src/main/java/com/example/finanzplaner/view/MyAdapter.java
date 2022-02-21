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
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    Context context;
    //Arrays um aus der Liste von Ojekten mehrere Listen mit den Entsprechenden Attributen zu erstellen
    ArrayList<String> name;
    private ArrayList<Float> betrag;
    private ArrayList<LocalDate> datum;
    private ArrayList<Einnahmekategorie> einnahmekategorie;
    private ArrayList<Boolean> wiederkehrend;


    //Konstruktor
    public MyAdapter(Context ct, ArrayList<String> name, ArrayList<Float> betrag, ArrayList<LocalDate> datum, ArrayList<Einnahmekategorie> einnahmekategorie, ArrayList<Boolean> wiederkehrend) {
        context = ct;
        this.name = name;
        this.betrag = betrag;
        this.datum = datum;
        this.einnahmekategorie = einnahmekategorie;
        this.wiederkehrend = wiederkehrend;
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
    public int getItemCount() { return name.size(); }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titelTW.setText(name.get(position));
        holder.betragTW.setText(String.valueOf(betrag.get(position)));
        holder.datumTW.setText( datum.get(position).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        holder.kategorieTW.setText(einnahmekategorie.get(position).getName());
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
