package StrategiaStudent;

import Main.Student;

import java.io.Serializable;

public class StypendiumSredniaOcen implements StypendiumStrategia, Serializable {
    public void policzStypendium(Student student){
        student.setStypendium(student.getStypendium()+50);
    }
}
