package StrategiaStudent;

import Main.Student;

import java.io.Serializable;

public class StypendiumSredniaOcen implements StypendiumStrategia, Serializable {
    public double policzStypendium(Student student){
        double stypendium=0;
        if (student.policzSrednia(student.getKursy()) > 4 && student.policzSrednia(student.getKursy())<4.5){
            stypendium=300;
        }
        if (student.policzSrednia(student.getKursy()) > 4.5){
            stypendium=500;
        }
        return stypendium;
    }
}
