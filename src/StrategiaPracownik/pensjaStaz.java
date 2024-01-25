package StrategiaPracownik;

import Main.Osoba;
import Main.Pracownik;

import java.io.Serializable;
import java.util.ArrayList;

public class pensjaStaz implements PensjaStrategia, Serializable {
    public double policzPensje(Pracownik pracownik) {
    double newPensja = 0;
    newPensja = pracownik.getZarobki() + 100;
    return newPensja;
    }
}
