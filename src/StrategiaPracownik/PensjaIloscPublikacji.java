package StrategiaPracownik;

import Main.Osoba;
import Main.*;

import java.io.Serializable;
import java.util.ArrayList;

public class PensjaIloscPublikacji implements PensjaStrategia, Serializable {
    @Override
    public double policzPensje(Pracownik pracownik) {
        double newPensja = 0;
        newPensja = (pracownik.getZarobki() + ((PracownikUczelniNaukowoDydaktyczny)pracownik).getLiczbaPublikacji()*10);
        return newPensja;
    }
}
