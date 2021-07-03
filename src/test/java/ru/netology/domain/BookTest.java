package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book item = new Book(4, "Now You See Me", 202, "Sharon Bolton");

    @Test
    public void matchName() {
        assertEquals(true, item.matches("Now You See Me"));
    }

    @Test
    public void matchAuthor() {
        assertEquals(true, item.matches("Sharon Bolton"));
    }

    @Test
    public void notMatch() {
        assertEquals(false, item.matches("Appe"));
    }
}