package Main;

import java.io.*;
import java.util.ArrayList;

public class Serializacja {
    public static void odczytSer(ArrayList<Osoba> osoby, File plik) {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(plik))) {
            Object obj;
            while ((obj = is.readObject()) != null) {
                if (obj instanceof Osoba) {
                    osoby.add((Osoba) obj);
                }
            }
        } catch (EOFException ignored) {
        } catch(ClassNotFoundException |IOException e){
            e.printStackTrace();
        }
    }


    public static void zapisSer(ArrayList<Osoba> osoby, File plik){
        try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream(plik))) {
            for (int i = 0; i < osoby.size(); i++) {
                so.writeObject(osoby.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
