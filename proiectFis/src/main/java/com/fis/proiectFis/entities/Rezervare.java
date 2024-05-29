package com.fis.proiectFis.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Rezervare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String oras_dus;
    private String oras_intors;
    private LocalDate data_plecare;
    private LocalDate data_sosire;
    private int nr_locuri_copii;
    private int nr_locuri_adulti;
    private int nr_locuri_seniori;
    private String tip_clasa;
//    private boolean cu_retur;
    private float discount_retur;
    private float discount_last_minute;
    String nume;
//    String


    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="utilizator_id", referencedColumnName = "id")
    private Utilizator utilizator;
    public int getId() {
        return id;
    }

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="zbor_id", referencedColumnName = "id")
    private Zbor zbor;
    public int getIdZbor() {
        return id;
    }

    public Zbor getZbor() {
        return zbor;
    }

    public void setZbor(Zbor zbor) {
        this.zbor = zbor;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOras_dus() {
        return oras_dus;
    }

    public void setOras_dus(String oras_dus) {
        this.oras_dus = oras_dus;
    }

    public String getOras_intors() {
        return oras_intors;
    }

    public void setOras_intors(String oras_intors) {
        this.oras_intors = oras_intors;
    }

    public LocalDate getData_plecare() {
        return data_plecare;
    }

    public void setData_plecare(LocalDate data_plecare) {
        this.data_plecare = data_plecare;
    }

    public LocalDate getData_sosire() {
        return data_sosire;
    }

    public void setData_sosire(LocalDate data_sosire) {
        this.data_sosire = data_sosire;
    }

    public int getNr_locuri_copii() {
        return nr_locuri_copii;
    }

    public void setNr_locuri_copii(int nr_locuri_copii) {
        this.nr_locuri_copii = nr_locuri_copii;
    }

    public int getNr_locuri_adulti() {
        return nr_locuri_adulti;
    }

    public void setNr_locuri_adulti(int nr_locuri_adulti) {
        this.nr_locuri_adulti = nr_locuri_adulti;
    }

    public int getNr_locuri_seniori() {
        return nr_locuri_seniori;
    }

    public void setNr_locuri_seniori(int nr_locuri_seniori) {
        this.nr_locuri_seniori = nr_locuri_seniori;
    }

    public String getTip_clasa() {
        return tip_clasa;
    }

    public void setTip_clasa(String tip_clasa) {
        this.tip_clasa = tip_clasa;
    }

    public float getDiscount_retur() {
        return discount_retur;
    }

    public void setDiscount_retur(float discount_retur) {
        this.discount_retur = discount_retur;
    }

    public float getDiscount_last_minute() {
        return discount_last_minute;
    }

    public void setDiscount_last_minute(float discount_last_minute) {
        this.discount_last_minute = discount_last_minute;
    }
}
