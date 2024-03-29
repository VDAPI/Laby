package Main;

import StrategiaStudent.StypendiumAktywnosc;
import StrategiaStudent.StypendiumStrategia;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Osoba{
    private double Stypendium;
    private String indeks;
    private byte nrSemestru;
    private byte stopienStudiow;
    private StypendiumStrategia stypendiumStrategia;
    private ArrayList<Kursy> kursy = new ArrayList<Kursy>();
    private static final long serialVersionUID = 1275997691580326078L;

    public Student(String pesel, String imie, String nazwisko, LocalDate dataUrodzenia,String plec, String indeks,byte stopienStudiow, byte nrSemestru) {
        super(pesel, imie, nazwisko, dataUrodzenia, plec);
        this.indeks = indeks;
        this.stopienStudiow = stopienStudiow;
        this.nrSemestru = nrSemestru;
        this.stypendiumStrategia = new StypendiumAktywnosc();
    }

    public StypendiumStrategia getStypendiumStrategia() {
        return stypendiumStrategia;
    }

    public double getStypendium() {
        return Stypendium;
    }

    public void setStypendium(double stypendium) {
        Stypendium = stypendium;
    }

    public byte getStopienStudiow() {
        return stopienStudiow;
    }
    public void ustawMetodeStypendium(StypendiumStrategia stypendiumStrategia){
        this.stypendiumStrategia = stypendiumStrategia;
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public byte getNrSemestru() {
        return nrSemestru;
    }

    public void setNrSemestru(byte nrSemestru) {
        this.nrSemestru = nrSemestru;
    }

    public ArrayList<Kursy> getKursy() {
        return kursy;
    }

    public void setKursy(ArrayList<Kursy> kursy) {
        this.kursy = kursy;
    }

    public void dodajKurs(String nazwa, String prowadzacy){
        this.kursy.add(new Kursy(nazwa, prowadzacy));
    }
    public void dodajOcene(double ocena, String nazwaKursu){
        for (int i = 0; i < kursy.size(); i++) {
            if(kursy.get(i).getNazwa().equals(nazwaKursu)){
                kursy.get(i).dodajOcene(ocena);
            }
        }
    }

    public Kursy getKurs(String nazwaKursu, ArrayList<Kursy> kursy){
        for (int i = 0; i < kursy.size(); i++) {
            if((kursy.get(i)).equals(nazwaKursu)){
                return kursy.get(i);
            }
        }
        return null;
    }

    public void getStanKursu(String nazwaKursu){
        for (int i = 0; i < kursy.size(); i++) {
            if((kursy.get(i)).equals(nazwaKursu)){
                kursy.get(i).toString();
            }
            else {
                System.out.println("Taki kurs nie istnieje!");
            }
        }
    }

    public void getAllKursy(){
            for (int i = 0; i < kursy.size(); i++) {
                kursy.get(i).toString();
            }
    }

    public double policzSrednia(ArrayList<Kursy> kursy){
        double srednia=0;
        int ilosc=0;
        for (int i = 0; i < kursy.size(); i++) {
            for (double element: kursy.get(i).getOceny()) {
                srednia += element;
                ilosc++;
            }
        }
        srednia = srednia/ilosc;
        return srednia;
    }

    @Override
    public String toString() {
        return super.toString()+"\nNumer indeksu: "+ indeks +"\nStopien studiow "+stopienStudiow+"\nSemestr: "+ nrSemestru +"\nKursy: " + kursy.toString();
    }

}

























