package Main;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Kursy implements Serializable {
    private String nazwa;
    private boolean czyZdaje;
    private String prowadzacy;
    private ArrayList<Double> oceny = new ArrayList<Double>();

    public Kursy(String nazwa, String prowadzacy) {
        this.nazwa = nazwa;
        this.prowadzacy = prowadzacy;
    }


    public String getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(String prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public boolean getCzyZdaje() {
        double srednia=0;
        for (double element: getOceny()) {
            srednia += element;
        }
        if(srednia/getOceny().size()>=3){
            return true;
        }
        else if(srednia/getOceny().size()<3){
            return false;
        }
        return false;
    }


    public ArrayList<Double> getOceny() {
        return oceny;
    }

    public void setOceny(ArrayList<Double> oceny) {
        this.oceny = oceny;
    }

    public void dodajOcene(double ocena){
        oceny.add(ocena);
    }

    @Override
    public String toString() {
        super.toString();
        return "\nNazwa: "+nazwa+"\nProwadzacy: "+prowadzacy+"\nOceny: "+oceny+"\nCzy zdaje: "+getCzyZdaje()+"\n";
    }
}