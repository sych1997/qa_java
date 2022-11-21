package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> list = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), list);
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        int quantity = feline.getKittens();
        assertEquals(1, quantity);
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int quantity = feline.getKittens(3);
        assertEquals(3, quantity);
    }
}