package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private final String male;
    private final boolean expected;

    public LionTest(String male, boolean expected) {
        this.male = male;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Пол = {0}, Ответ ={1}")
    public static Object[][] getCities() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"что ", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void getKittens() throws Exception {
        try {
            Lion lion = new Lion(male, feline);
            lion.getKittens();
            Mockito.verify(feline).getKittens();
        } catch (Exception thrown) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
        }
    }

    @Test
    public void doesHaveMane() throws Exception {
        try {
            Lion lion = new Lion(male, feline);
            boolean mane = lion.doesHaveMane();
            assertEquals(expected, mane);
        } catch (Exception thrown) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
        }
    }

    @Test
    public void getFood() throws Exception {
        try {
            Lion lion = new Lion(male, feline);
            lion.getFood();
            Mockito.verify(feline).getFood("Хищник");
        } catch (Exception thrown) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
        }
    }
}