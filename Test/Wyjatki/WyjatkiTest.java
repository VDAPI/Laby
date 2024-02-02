package Wyjatki;

import Main.Student;
import StrategiaStudent.StypendiumSredniaOcen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WyjatkiTest {
    Student student1;
    Student student2;
    Student student3;
    @BeforeEach
    void setUp() {
        student1 = new Student("12312312312", "Dawid", "Pilarski", LocalDate.of(2000,10,5), "Mezczynza", "123123", (byte) 1, (byte) 1);
        student2 = new Student("35253252352", "Lider", "Piechowski", LocalDate.of(2005,10,6), "Mezczynza", "14123", (byte) 1, (byte) 1);
        student3 = new Student("1253245322", "Marcello", "Malecki", LocalDate.of(2000,5,5), "Mezczynza", "123123", (byte) 1, (byte) 1);

        student1.dodajKurs("Analiza matematyczna", "Krzysztof Michalik");
        for (int i = 0; i < student1.getKursy().size(); i++) {student1.getKursy().get(i).dodajOcene(5);}
        student1.ustawMetodeStypendium(new StypendiumSredniaOcen());

        student2.dodajKurs("Analiza matematyczna", "Krzysztof Michalik");
        for (int i = 0; i < student2.getKursy().size(); i++) {student2.getKursy().get(i).dodajOcene(3);}
        student2.ustawMetodeStypendium(new StypendiumSredniaOcen());

        student3.dodajKurs("Analiza matematyczna", "Krzysztof Michalik");
        for (int i = 0; i < student3.getKursy().size(); i++) {student3.getKursy().get(i).dodajOcene(4.5);}
        student3.ustawMetodeStypendium(new StypendiumSredniaOcen());
    }

    @Test
    void test1() {
        assertEquals(500, student1.getStypendiumStrategia().policzStypendium(student1));
    }
    @Test
    void test2() {
        assertEquals(0, student2.getStypendiumStrategia().policzStypendium(student2));
    }
    @Test
    void test3() {
        assertEquals(300, student3.getStypendiumStrategia().policzStypendium(student3));
    }

}