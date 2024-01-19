package Main;

import java.util.ArrayList;

public class Wyszukaj {

    public static ArrayList<Osoba> wyszukajPoNazwisku(ArrayList<Osoba> osoby, String nazwisko, Class<? extends Osoba> klasa) {
        ArrayList<Osoba> indeksy = new ArrayList<>();
        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i).getNazwisko().equals(nazwisko) && klasa.isAssignableFrom(osoby.get(i).getClass())) {
                indeksy.add(osoby.get(i));
            }
        }
        return indeksy;
    }

    public static ArrayList<Osoba> wyszukajStudentaPoIndeksie(ArrayList<Osoba> osoby, String indeks) {
        ArrayList<Osoba> indeksy = new ArrayList<Osoba>();
        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Student && (osoby.get(i)).getIndeks().equals(indeks)) {
                indeksy.add(osoby.get(i));
            }
        }
        return indeksy;
    }

    public static ArrayList<Osoba> wyszukajPracownikaUczelniOWartosciDorobkuPowyzejT(ArrayList<Osoba> osoby, int T, Class<? extends Osoba> klasa){
        ArrayList<Osoba> indeksy = new ArrayList<>();
        for (int i = 0; i < osoby.size(); i++) {
            if (klasa.isAssignableFrom(osoby.get(i).getClass()) && (osoby.get(i).getWartoscDorobku()) > T) {
                indeksy.add(osoby.get(i));
            }
        }
        return indeksy;
    }

    public static ArrayList<Osoba> wyszukajPracownikaAdministracyjnegoPoStanowusku(ArrayList<Osoba> osoby, String stanowisko, Class<? extends Osoba> klasa) {
        ArrayList<Osoba> indeksy = new ArrayList<>();
        for (int i = 0; i < osoby.size(); i++) {
            if (klasa.isAssignableFrom(osoby.get(i).getClass()) && (osoby.get(i)).getStanowisko().equals(stanowisko)) {
                indeksy.add(osoby.get(i));
            }
        }
        return indeksy;
    }



}
