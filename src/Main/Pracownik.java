package Main;
import StrategiaPracownik.PensjaStrategia;
import StrategiaStudent.StypendiumStrategia;

import java.time.LocalDate;
import java.util.ArrayList;


public abstract class Pracownik extends Osoba {
    private double zarobki;
    private String staz;
    private String stanowisko;
    private PensjaStrategia pensjaStrategia;

    public Pracownik(String pesel, String imie, String nazwisko, LocalDate dataUrodzenia, String plec, double zarobki, String staz, String stanowisko) {
        super(pesel, imie, nazwisko, dataUrodzenia, plec);
        this.zarobki = zarobki;
        this.staz = staz;
        this.stanowisko = stanowisko;
    }

    public double getZarobki() {
        return zarobki;
    }

    public void setZarobki(double zarobki) {
        this.zarobki = zarobki;
    }

    public String getStaz() {
        return staz;
    }

    public void setStaz(String staz) {
        this.staz = staz;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nStanowisko: " +stanowisko+ "\nStaz: "+staz+"\nZarobki: "+zarobki;
    }

    public void ustawMetodeStypendium(PensjaStrategia pensjaStrategia){
        this.pensjaStrategia = pensjaStrategia;
    }

}
