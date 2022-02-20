package com.example.finanzplaner.view;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;

public class MyAdapter extends RecyclerView. Adapter<MyAdapter.ViewHolder>{



     public MyAdapter() {




     }

     @NonNull
     @Override
     public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         return null;
     }

     @Override
     public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

     }

     @Override
     public int getItemCount() {
         return 0;
     }

     public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder (@NonNull View itemView){
        super(itemView);
        }
}
        }
