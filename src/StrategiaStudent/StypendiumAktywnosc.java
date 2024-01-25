package StrategiaStudent;

import Main.Student;

import java.io.Serializable;

public class StypendiumAktywnosc implements StypendiumStrategia, Serializable {
    public double policzStypendium(Student student){

        return student.getStypendium()+1;
    }
}
