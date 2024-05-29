package com.fis.proiectFis;

import com.fis.proiectFis.entities.Rezervare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RezervareTest {

    private Rezervare rezervare;

    @BeforeEach
    public void setUp() {
        rezervare = new Rezervare();
    }

    @Test
    public void testOrasDus() {
        rezervare.setOras_dus("Bucuresti");
        assertEquals("Bucuresti", rezervare.getOras_dus());
    }

    @Test
    public void testOrasIntors() {
        rezervare.setOras_intors("Cluj");
        assertEquals("Cluj", rezervare.getOras_intors());
    }

    @Test
    public void testDataPlecare() {
        LocalDate dataPlecare = LocalDate.of(2024, 5, 28);
        rezervare.setData_plecare(dataPlecare);
        assertEquals(dataPlecare, rezervare.getData_plecare());
    }

    @Test
    public void testDataSosire() {
        LocalDate dataSosire = LocalDate.of(2024, 5, 29);
        rezervare.setData_sosire(dataSosire);
        assertEquals(dataSosire, rezervare.getData_sosire());
    }

    @Test
    public void testNrLocuriAdulti() {
        rezervare.setNr_locuri_adulti(3);
        assertEquals(3, rezervare.getNr_locuri_adulti());
}
}
