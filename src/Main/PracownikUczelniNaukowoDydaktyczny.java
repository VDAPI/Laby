package Main;
import java.time.LocalDate;
import java.util.ArrayList;

public class PracownikUczelniNaukowoDydaktyczny extends Pracownik{
    private int liczbaPublikacji;
    private static final long serialVersionUID = 1275997691580326078L;

    public PracownikUczelniNaukowoDydaktyczny(String pesel, String imie, String nazwisko, LocalDate dataUrodzenia, String plec, double zarobki, String staz, String stanowisko, int liczbaPublikacji) {
        super(pesel, imie, nazwisko, dataUrodzenia, plec, zarobki, staz, stanowisko);
        this.liczbaPublikacji = liczbaPublikacji;
    }

    public int getLiczbaPublikacji() {
        return liczbaPublikacji;
    }

    public void setLiczbaPublikacji(int liczbaPublikacji) {
        this.liczbaPublikacji = liczbaPublikacji;
    }
    @Override
    public void dodajKurs(String nazwa, String prowadzacy) {}
    @Override
    public void dodajOcene(double ocena, String nazwaKursu) {}

    @Override
    public String toString() {
        return super.toString()+"\nLiczba publikacji: " + liczbaPublikacji;
    }
    public String getIndeks(){return null;};



}
