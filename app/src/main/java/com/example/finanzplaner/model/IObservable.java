package com.example.finanzplaner.model;

import com.example.finanzplaner.view.IObserver;

import java.io.Serializable;

public interface IObservable {

    public void anmelden(IObserver view);
    public void abmelden(IObserver view);

    public void benachrichtigeBeobachter();

}
