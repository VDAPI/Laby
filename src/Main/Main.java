package Main;


import Grafika.MenuGlowne.MenuGlowne;
import Wyjatki.Wyjatek;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static Main.Wyszukaj.*;
import static Wyjatki.Wyjatki.sprawdzCzyPusty;
import static Wyjatki.Wyjatki.sprawdzNumer;

//TODO TEN KOD NIEAKTUALNY TYLKO METODY NA DOLE PRZENIESC GDZIE INDZIEJ I NAPRAWIC WYJATKI

public class Main {
    public static void main(String[] args) {



        ArrayList<Osoba> osoby = new ArrayList<>();
        File plik = new File("ListaOsob.ser");
        Serializacja.odczytSer(osoby, plik);

        JFrame frame = new JFrame();
        frame.add(new MenuGlowne());

        Scanner scan = new Scanner(System.in);
        String wybor = null;
        ArrayList<Integer> wyborList = new ArrayList<>();
        int wyborInt = -1;

        /*menu();
        Loop:
        while (scan.hasNextLine()) {
            wybor = scan.nextLine();
            switch (wybor) {
                case "1": // MENU STUDENT
                    menuStudent();
                    wybor = scan.nextLine();

                    switch (wybor) {
                        case "1": //DODAJ STUDENTA
                            dodajStudenta(osoby, scan);
                            break;
                        case "2": //WYSZUKAJ STUDENTA PO INDEKSIE
                            System.out.print("Podaj indeks: ");
                            String indeks = scan.nextLine();
                            wyborInt = wyszukajStudentaPoIndeksie(osoby, indeks);
                            if (wyborInt >= 0) {
                                menuStudent2();
                                wybor = scan.nextLine();
                                switch (wybor) {
                                    case "1": // DODAJ KURS
                                        System.out.print("Podaj nazwe kursu: ");
                                        String nazwaKursu = scan.nextLine();
                                        System.out.print("Podaj imie i nazwisko wykładowcy: ");
                                        String wykladowca = scan.nextLine();
                                        osoby.get(wyborInt).dodajKurs(nazwaKursu, wykladowca);
                                        break;
                                    case "2": //DODAJ OCENE DO KURSU
                                        System.out.print("Podaj nazwe kursu: ");
                                        nazwaKursu = scan.nextLine();
                                        System.out.print("Podaj ocene: ");
                                        double ocena = Double.parseDouble(scan.nextLine());
                                        osoby.get(wyborInt).dodajOcene(ocena, nazwaKursu);
                                        break;
                                    case "3": // WYSWIETL INFORMACJE O STUDENCIE
                                        System.out.println(osoby.get(wyborInt).toString());
                                }
                            } else { //W PRZYPADKU GDY NIE MA TAKIEGO STUDENTA
                                System.out.println("Nie ma studenta o takim indeksie!!!");
                            }
                            break;
                        case "3": // WYSZUKIWNIE STUDENTA PO NAZWISKU
                            System.out.print("Podaj nazwisko: ");
                            String nazwisko = scan.nextLine();
                            wyborList = wyszukajPoNazwisku(osoby, nazwisko, Student.class);
                            if (!wyborList.isEmpty()) {
                                for (int i = 0; i < wyborList.size(); i++) {
                                    System.out.println((i + 1) + osoby.get(wyborList.get(i)).toString());
                                }
                                System.out.print("Wybierz numer studenta: ");
                                wyborInt = Integer.parseInt(scan.nextLine()) - 1;
                                menuStudent2();
                                wybor = scan.nextLine();
                                switch (wybor) {
                                    case "1": // DODAWANIE KURSU DO STUDENTA
                                        System.out.print("Podaj nazwe kursu: ");
                                        String nazwaKursu = scan.nextLine();
                                        System.out.print("Podaj imie i nazwisko wykładowcy");
                                        String wykladowca = scan.nextLine();
                                        osoby.get(wyborList.get(wyborInt)).dodajKurs(nazwaKursu, wykladowca);
                                        break;
                                    case "2": // DODAWANIE OCENY DO KURSU
                                        System.out.print("Podaj nazwe kursu: ");
                                        nazwaKursu = scan.nextLine();
                                        System.out.print("Podaj ocene: ");
                                        double ocena = Double.parseDouble(scan.nextLine());
                                        osoby.get(wyborList.get(wyborInt)).dodajOcene(ocena, nazwaKursu);
                                        break;
                                    case "3": // INFORMACJE O STUDENCIE
                                        System.out.println(osoby.get(wyborList.get(wyborInt)).toString());
                                }
                            } else {
                                System.out.println("Nie ma studenta o takim nazwisku!!!");
                            }
                            break;
                    }
                    break;
//koniec Studenta
                case "2": // PRACOWNIK UCZELNI
                    menuPracownikUczelni();
                    wybor = scan.nextLine();

                    switch (wybor) {
                        case "1": //DODAJ PRACOWNIKA UCZELNI
                            dodajPracownikaUczelni(osoby, scan);
                            break;

                        case "2": //WYSZUKAJ PRACOWNIKA UCZELNI PO DOROBKU T
                            System.out.print("Podaj wartosc dorobku T: ");
                            int t = Integer.parseInt(scan.nextLine());
                            wyborList = wyszukajPracownikaUczelniOWartosciDorobkuPowyzejT(osoby, t, PracownikUczelni.class);
                            if (!wyborList.isEmpty()) {
                                for (int i = 0; i < wyborList.size(); i++) {
                                    System.out.println((i + 1) + osoby.get(wyborList.get(i)).toString());
                                }
                                System.out.println("Wybierz osobe: ");
                                wyborInt = Integer.parseInt(scan.nextLine()) - 1;
                                menuPracownikUczelni2();
                                wybor = scan.nextLine();
                                switch (wybor) {
                                    case "1": //WYSWIETL INFORMACJE O WYBRANYM PRACOWNIKU
                                        System.out.println(osoby.get(wyborList.get(wyborInt)).toString());
                                }
                            }
                            break;

                        case "3": //WYSZUKAJ PRACOWNIKA UCZELNII PO NAZWISKU
                            System.out.print("Podaj nazwisko: ");
                            String nazwisko = scan.nextLine();
                            wyborList = wyszukajPoNazwisku(osoby, nazwisko, PracownikUczelni.class);
                            if (!wyborList.isEmpty()) {
                                for (int i = 0; i < wyborList.size(); i++) {
                                    System.out.println((i + 1) + osoby.get(wyborList.get(i)).toString());
                                }
                                System.out.print("Wybierz osobe: ");
                                wyborInt = Integer.parseInt(scan.nextLine()) - 1;
                                menuPracownikUczelni2();
                                wybor = scan.nextLine();
                                switch (wybor) {
                                    case "1":
                                        System.out.println(osoby.get(wyborInt).toString());
                                }
                            }
                            break;
                    }
                    break;
                case "3": // PRACOWNIK NAUKOWY
                    menuPracownikNaukowy();
                    wybor = scan.nextLine();

                    switch (wybor) {
                        case "1": // DODAJ PRACOWNIKA NAUKOWEGO
                            dodajPracownikaNaukowego(osoby, scan);
                            break;

                        case "2": // WYSZUKAJ PRACOWNIKA NAUKOWEGO PO STANOWISKU
                            System.out.print("Podaj nazwe stanowiska: ");
                            String stanowisko = scan.nextLine();
                            wyborList = wyszukajPracownikaAdministracyjnegoPoStanowusku(osoby, stanowisko, PracownikUczelniNaukowoDydaktyczny.class);
                            if (!wyborList.isEmpty()) {
                                for (int i = 0; i < wyborList.size(); i++) {
                                    System.out.println((i + 1) + osoby.get(wyborList.get(i)).toString());
                                }
                                System.out.println("Wybierz osobe: ");
                                wyborInt = Integer.parseInt(scan.nextLine()) - 1;
                                menuPracownikNaukowy2();
                                wybor = scan.nextLine();
                                switch (wybor) { // MENU PRACOWNIK NAUKOWY 2
                                    case "1":
                                        System.out.println(osoby.get(wyborInt).toString());
                                }
                            }
                            break;

                        case "3": // WYSZUKIWANIE PRACOWNIKA NAUKOWEGO PO NAZWISKU
                            System.out.print("Podaj nazwisko: ");
                            String nazwisko = scan.nextLine();
                            wyborList = wyszukajPoNazwisku(osoby, nazwisko, PracownikUczelniNaukowoDydaktyczny.class);
                            if (!wyborList.isEmpty()) {
                                for (int i = 0; i < wyborList.size(); i++) {
                                    System.out.println((i + 1) + osoby.get(wyborList.get(i)).toString());
                                }
                                System.out.print("Wybierz osobe: ");
                                wyborInt = Integer.parseInt(scan.nextLine()) - 1;
                                menuPracownikNaukowy2();
                                wybor = scan.nextLine();
                                switch (wybor) {
                                    case "1":
                                        System.out.println(osoby.get(wyborInt).toString());
                                }
                            }
                            break;
                    }
                    break;
                case "4":
                    wyswietlInformacjeOWszystkich(osoby);
                    break;
                default:
                    break Loop;
            }
            menu();
        }*/

        Serializacja.zapisSer(osoby, plik);


    }

    public static void wyswietlInformacjeOWszystkich(ArrayList<Osoba> osoby) {
        for (int i = 0; i < osoby.size(); i++) {
            System.out.println(osoby.get(i).toString());
        }
    }

    public static void menu() {
        System.out.println("\n\nWybierz opcje: ");
        System.out.println("1. Student");
        System.out.println("2. Pracownik Uczelni");
        System.out.println("3. Pracownik Naukowy");
        System.out.println("4. Wyswietl informacje o wszystkich");
        System.out.print("Wybor: ");
    }

    public static void menuStudent() {
        System.out.println("\nWybierz opcje: ");
        System.out.println("1. Dodaj Studenta");
        System.out.println("2. Wyszukaj po indeksie");
        System.out.println("3. Wyszukaj po nazwisku");
        System.out.print("Wybor: ");
    }

    public static void menuPracownikUczelni() {
        System.out.println("\nWybierz opcje: ");
        System.out.println("1. Dodaj Pracownika Uczelnii");
        System.out.println("2. Wyszukaj po wartosci dorobku powyzej T");
        System.out.println("3. Wyszukaj po nazwisku");
        System.out.print("Wybor: ");
    }

    public static void menuPracownikNaukowy() {
        System.out.println("\nWybierz opcje: ");
        System.out.println("1. Dodaj Pracownika Naukowego");
        System.out.println("2. Wyszukaj po stanowisku");
        System.out.println("3. Wyszukaj po nazwisku");
        System.out.print("Wybor: ");
    }

    public static void menuStudent2() {
        System.out.println("\nWybierz opcje: ");
        System.out.println("1. Dodaj kurs");
        System.out.println("2. Dodaj ocene");
        System.out.print("Wybor: ");
    }

    public static void menuPracownikUczelni2() {
        System.out.println("\nWybierz opcje: ");
        System.out.println("1. Wyswietl informacje");
        System.out.print("Wybor: ");
    }

    public static void menuPracownikNaukowy2() {
        System.out.println("\nWybierz opcje: ");
        System.out.println("1. Wyswietl informacje");
        System.out.print("Wybor: ");
    }

    public static void dodajOsobe(ArrayList<Osoba> osoby, Scanner scan, String imie, String nazwisko, String pesel, String plec, LocalDate dataUrodzenia) {
        try {
            System.out.print("Podaj imie: ");
            imie = sprawdzCzyPusty(scan.nextLine());
            System.out.print("Podaj nazwisko ");
            nazwisko = sprawdzCzyPusty(scan.nextLine());

            System.out.print("Podaj numer PESEL: ");
            pesel = sprawdzNumer(scan.nextLine(), 11);

            System.out.print("Podaj plec: ");
            plec = sprawdzCzyPusty(scan.nextLine());
            System.out.print("Podaj date urodzenia w formacie (yyyy-mm-dd): ");

            try {
                dataUrodzenia = LocalDate.parse(scan.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Wprowadzono zly format daty! " + e.getMessage());
                return;
            }

        } catch (Wyjatek e) {
            e.printStackTrace();
            return;
        }
    }

    public static void dodajStudenta(ArrayList<Osoba> osoby, String imie, String nazwisko, String pesel, String plec
    ,String indeks, String dataUrodzenia, String stopienStudiow, String numerSemestru) {
        LocalDate data; byte stopien, studia;
        try {
            sprawdzCzyPusty(imie);
            sprawdzCzyPusty(nazwisko);
            sprawdzCzyPusty(plec);
            try {
                data = LocalDate.parse(dataUrodzenia);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Wprowadzono nieprawidlowy format daty", "Blad", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (Wyjatek e) {
            JOptionPane.showMessageDialog(null, "Puste pole lub bledny pesel!", "Blad", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            sprawdzNumer(indeks, 6);
            sprawdzNumer(pesel, 11);
            try {
                studia = Byte.parseByte(sprawdzCzyPusty(stopienStudiow));
                stopien = Byte.parseByte(sprawdzCzyPusty(numerSemestru));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wprowadzono bledny indeks lub pesel", "Blad", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Wyjatek e) {
            JOptionPane.showMessageDialog(null, "Wprowadzono zly format stopien studiow lub nr semestru!", "Blad", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Dodano studenta!", "Dodano",JOptionPane.INFORMATION_MESSAGE);
        osoby.add(new Student(pesel, imie, nazwisko, data, plec, indeks, (byte) stopien, (byte) studia));
    }

    public static void dodajPracownikaNaukowego(ArrayList<Osoba> osoby, Scanner scan) {
        String imie=null, nazwisko=null, pesel=null, plec=null, staz, stanowisko;
        LocalDate dataUrodzenia=null;
        Double zarobki;
        int liczbaPublikacji;

        dodajOsobe(osoby, scan, imie, nazwisko, pesel, plec, dataUrodzenia);
        if(dataUrodzenia==null){return;}

        try {
            System.out.print("Podaj zarobki: ");
            zarobki = Double.parseDouble(scan.nextLine());

            System.out.print("Podaj liczbe publikacji: ");
            liczbaPublikacji = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e){
            e.printStackTrace();
            return;
        }
        try{
            System.out.print("Podaj staz: ");
            staz = sprawdzCzyPusty(scan.nextLine());
            System.out.print("Podaj stanowisko: ");
            stanowisko = sprawdzCzyPusty(scan.nextLine());
        } catch (Wyjatek e){
            e.printStackTrace();
            return;
        }
        osoby.add(new PracownikUczelniNaukowoDydaktyczny(pesel, imie, nazwisko, dataUrodzenia, plec, zarobki, staz, stanowisko, liczbaPublikacji));
    }

    public static void dodajPracownikaUczelni(ArrayList<Osoba> osoby, String imie, String nazwisko, String pesel, String plec,
                                              String kwota, String staz, String stanowisko, String data, String dorobek) {
        LocalDate dataUrodzenia=null;
        Double zarobki;
        int liczbaPublikacji, wartoscDorobku;
        try {
            sprawdzCzyPusty(imie);
            sprawdzCzyPusty(nazwisko);
            sprawdzCzyPusty(plec);
            try {
                dataUrodzenia = LocalDate.parse(data);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Wprowadzono nieprawidlowy format daty", "Blad", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (Wyjatek e) {
            JOptionPane.showMessageDialog(null, "Puste pole lub bledny pesel!", "Blad", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            sprawdzNumer(pesel, 11);
            try {
                wartoscDorobku = Integer.parseInt(sprawdzCzyPusty(dorobek));
                zarobki = Double.parseDouble(sprawdzCzyPusty(kwota));

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wprowadzono bledny indeks lub pesel", "Blad", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Wyjatek e) {
            JOptionPane.showMessageDialog(null, "Wprowadzono zly format stopien studiow lub nr semestru!", "Blad", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Dodano pracownika!", "Dodano",JOptionPane.INFORMATION_MESSAGE);
        osoby.add(new PracownikUczelni(pesel, imie, nazwisko, dataUrodzenia, plec, zarobki, staz, stanowisko, wartoscDorobku));
    }
    public static void dodajPracownikaNaukowegoo(ArrayList<Osoba> osoby, String imie, String nazwisko, String pesel, String plec,
                                              String kwota, String staz, String stanowisko, String data, String publikacje) {
        LocalDate dataUrodzenia=null;
        Double zarobki;
        int liczbaPublikacji, wartoscDorobku;
        try {
            sprawdzCzyPusty(imie);
            sprawdzCzyPusty(nazwisko);
            sprawdzCzyPusty(plec);
            try {
                dataUrodzenia = LocalDate.parse(data);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Wprowadzono nieprawidlowy format daty", "Blad", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (Wyjatek e) {
            JOptionPane.showMessageDialog(null, "Puste pole lub bledny pesel!", "Blad", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            sprawdzNumer(pesel, 11);
            try {
                liczbaPublikacji = Integer.parseInt(sprawdzCzyPusty(publikacje));
                zarobki = Double.parseDouble(sprawdzCzyPusty(kwota));

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Wprowadzono bledny indeks lub pesel", "Blad", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Wyjatek e) {
            JOptionPane.showMessageDialog(null, "Wprowadzono zly format stopien studiow lub nr semestru!", "Blad", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Dodano pracownika!", "Dodano",JOptionPane.INFORMATION_MESSAGE);
        osoby.add(new PracownikUczelniNaukowoDydaktyczny(pesel, imie, nazwisko, dataUrodzenia, plec, zarobki, staz, stanowisko, liczbaPublikacji));
    }
}
