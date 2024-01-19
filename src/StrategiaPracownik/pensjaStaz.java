package StrategiaPracownik;

import java.io.Serializable;

public class pensjaStaz implements PensjaStrategia, Serializable {
    @Override
    public double policzPensje(double warotosc) {
        return 0;
    }
}
