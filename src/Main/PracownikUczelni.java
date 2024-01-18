package Main;
import java.time.LocalDate;
import java.util.ArrayList;

public class PracownikUczelni extends Pracownik {
    private int wartoscDorobku;
    private static final long serialVersionUID = 1275997691580326078L;

    public PracownikUczelni(String pesel, String imie, String nazwisko, LocalDate dataUrodzenia, String plec, double zarobki, String staz, String stanowisko, int wartoscDorobku) {
        super(pesel, imie, nazwisko, dataUrodzenia, plec, zarobki, staz, stanowisko);
        this.wartoscDorobku = wartoscDorobku;
    }

    public int getWartoscDorobku() {
        return wartoscDorobku;
    }

    public void setWartoscDorobku(int wartoscDorobku) {
        this.wartoscDorobku = wartoscDorobku;
    }
    @Override
    public void dodajKurs(String nazwa, String prowadzacy) {}
    @Override
    public void dodajOcene(double ocena, String nazwaKursu) {}
    public String getIndeks(){return null;};
}