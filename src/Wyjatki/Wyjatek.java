package Wyjatki;

public class Wyjatek extends Exception {
    
    public Wyjatek(String s) {
        super(s);
    }


    //Metody przesłonięte z klasy Exception
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println("Fatalny BLAD!!");
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "\nFATALNY BLAD!! Popraw go jak najszybciej\n";

    }
}
