package com.example.finanzplaner.db;

import androidx.room.TypeConverter;

import com.example.finanzplaner.model.finanzverwaltung.Ausgabekategorie;
import com.example.finanzplaner.model.finanzverwaltung.Einnahmekategorie;

import java.time.LocalDate;

public class Converters {

    @TypeConverter
    public static String fromCalendarToString(LocalDate ld) {
        return ld.toString();
    }

    @TypeConverter
    public static LocalDate fromStringToLocalDate(String date) {
        return LocalDate.parse(date);
    }

    //Kategorien
    @TypeConverter
    public static String fromEkToString(Einnahmekategorie ek) {
        return ek.getName();
    }

    @TypeConverter
    public static Einnahmekategorie fromStringToEk(String name) {
        return new Einnahmekategorie(name);
    }

    @TypeConverter
    public static String fromAkToString(Ausgabekategorie ak) {
        return ak.getName();
    }

    @TypeConverter
    public static Ausgabekategorie fromStringToAk(String name) {
        return new Ausgabekategorie(name);
    }

}