package Wyjatki;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WyjatkiTest2 {

    @BeforeEach
    void setUp() {

    }

    @Test
    public void test1() {
        assertThrows(Wyjatek.class, () -> Wyjatki.sprawdzNumer("1234567",8));
    }

    @Test
    void test2() {
        assertDoesNotThrow(() -> Wyjatki.sprawdzNumer("12345",5));
    }
}