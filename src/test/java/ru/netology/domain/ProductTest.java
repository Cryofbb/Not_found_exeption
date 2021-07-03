package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product item = new Product(4, "Now You See Me", 202);

    @Test
    public void match(){
        assertEquals(true, item.matches("Now You See Me"));
    }

    @Test
    public void notMatch(){
        assertEquals(false, item.matches("Now Me"));
    }

}