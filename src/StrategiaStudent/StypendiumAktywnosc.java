package StrategiaStudent;

import Main.Student;

import java.io.Serializable;

public class StypendiumAktywnosc implements StypendiumStrategia, Serializable {
    public void policzStypendium(Student student){
        student.setStypendium(student.getStypendium()+100);
    }
}
