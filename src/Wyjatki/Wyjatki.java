package Wyjatki;

public class Wyjatki {
    public static String sprawdzNumer(String numer, int dlugosc) throws Wyjatek{
        if(numer.length() != dlugosc){
            throw new Wyjatek("Nieprawidlowa dlugosc numeru!");
        }
        if (!numer.matches("[0-9]+")) {
            throw new Wyjatek("Numer nie moze zawierac liter!");
        }

        return numer;
    }

    public static String sprawdzCzyPusty(String tekst) throws Wyjatek{
        if(tekst.length() == 0){
            throw new Wyjatek("Nie mozesz dodac pustego pola!");
        }
        return tekst;
    }

}
