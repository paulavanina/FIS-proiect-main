package com.fis.proiectFis;

import com.fis.proiectFis.entities.Utilizator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilizatorTest {

    private Utilizator utilizator;

    @BeforeEach
    public void setUp() {
        utilizator = new Utilizator();
    }

    @Test
    public void testParola() {
        utilizator.setParola("parola123");
        assertEquals("parola123", utilizator.getParola());
    }

    @Test
    public void testEmail() {
        utilizator.setEmail("email@example.com");
        assertEquals("email@example.com", utilizator.getEmail());
    }

    @Test
    public void testNume() {
        utilizator.setNume("Ion Popescu");
        assertEquals("Ion Popescu", utilizator.getNume());
    }

    @Test
    public void testRol() {
        utilizator.setRol("admin");
        assertEquals("admin", utilizator.getRol());
}}
