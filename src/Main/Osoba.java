package Main;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Osoba implements Serializable {
    private String pesel;
    private String imie;
    private String nazwisko;
    private LocalDate dataUrodzenia;
    private String plec;
    private static final long serialVersionUID = 1275997691580326078L;


    public Osoba(String pesel, String imie, String nazwisko, LocalDate dataUrodzenia, String plec) {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.plec = plec;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }
    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    @Override
    public String toString() {
        super.toString();
        return  "\nImie: " + imie + "\nNazwisko: " + nazwisko +"\nPlec: "+plec+"\nData urodzenia: "+ dataUrodzenia +"\nNumer PESEL: "+ pesel ;
    }
    public int getWartoscDorobku() {
        return 0;
    }

    public String getStanowisko() {
        return null;
    }

    public abstract void dodajKurs(String nazwa, String prowadzacy);
    public abstract void dodajOcene(double ocena, String nazwaKursu);

    public abstract String getIndeks();



}
