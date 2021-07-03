package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone item = new Smartphone(5, "Iphone", 500, "Apple");

    @Test
    public void matchName() {
        assertEquals(true, item.matches("Iphone"));
    }

    @Test
    public void matchManufacturer() {
        assertEquals(true, item.matches("Apple"));
    }

    @Test
    public void notMatch() {
        assertEquals(false, item.matches("Appe"));
    }
}