package Main;

import java.util.ArrayList;

public class Wyszukaj {

    public static ArrayList<Integer> wyszukajPoNazwisku(ArrayList<Osoba> osoby, String nazwisko, Class<? extends Osoba> klasa) {
        ArrayList<Integer> indeksy = new ArrayList<>();
        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i).getNazwisko().equals(nazwisko) && klasa.isAssignableFrom(osoby.get(i).getClass())) {
                indeksy.add(i);
            }
        }
        return indeksy;
    }

    public static int wyszukajStudentaPoIndeksie(ArrayList<Osoba> osoby, String indeks) {
        for (int i = 0; i < osoby.size(); i++) {
            if (osoby.get(i) instanceof Student && (osoby.get(i)).getIndeks().equals(indeks)) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> wyszukajPracownikaUczelniOWartosciDorobkuPowyzejT(ArrayList<Osoba> osoby, int T, Class<? extends Osoba> klasa){
        ArrayList<Integer> indeksy = new ArrayList<>();
        for (int i = 0; i < osoby.size(); i++) {
            if (klasa.isAssignableFrom(osoby.get(i).getClass()) && (osoby.get(i).getWartoscDorobku()) > T) {
                indeksy.add(i);
            }
        }
        return indeksy;
    }

    public static ArrayList<Integer> wyszukajPracownikaAdministracyjnegoPoStanowusku(ArrayList<Osoba> osoby, String stanowisko, Class<? extends Osoba> klasa) {
        ArrayList<Integer> indeksy = new ArrayList<>();
        for (int i = 0; i < osoby.size(); i++) {
            if (klasa.isAssignableFrom(osoby.get(i).getClass()) && (osoby.get(i)).getStanowisko().equals(stanowisko)) {
                indeksy.add(i);
            }
        }
        return indeksy;
    }



}
