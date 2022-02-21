package com.example.finanzplaner.model.finanzverwaltung;

import android.util.Log;

import com.example.finanzplaner.model.IObservable;
import com.example.finanzplaner.view.IObserver;

import java.util.ArrayList;
import java.util.List;

public class ViewManager {

    private static List<IObserver> views;

    public ViewManager(){
        views = new ArrayList<>();
    }


    public static void anmelden(IObserver view) {
        views.add(view);
        Log.v("mydebug", view.getClass().toString()+" hat sich angemeldet");
    }

    public static void abmelden(IObserver view) {
        views.remove(view);
    }

    public static void benachrichtigeBeobachter() {
        for (IObserver view: views) {
            view.update();
        }
    }

}
