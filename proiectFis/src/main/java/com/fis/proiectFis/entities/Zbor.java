package com.fis.proiectFis.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Zbor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cod_zbor;
    private int nr_locuri_total;
    private LocalDate data_plecare;
    private LocalDate data_sosire;
    private String nume_companie;
    private String orasdus;
    private String destinatie;
    private int  nr_locuri_seniori;
    private int  nr_locuri_adulti;
    private int  nr_locuri_copii;
    private float pret_economy;
    private float pret_business;
    private float pret_firstclass;
    private int locuri_business;
    private int locuri_economy;
    private int locuri_first;
    private String zile_operare;
    private double discount_retur;
    private double discount_last_minute;
//    private float discount;
//@JsonIgnore
@OneToMany(mappedBy = "zbor",
        cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Rezervare> rezervare;

    public double getDiscount_retur() {
        return discount_retur;
    }

    public void setDiscount_retur(double discount_retur) {
        this.discount_retur = discount_retur;
    }

    public double getDiscount_last_minute() {
        return discount_last_minute;
    }

    public void setDiscount_last_minute(double discount_last_minute) {
        this.discount_last_minute = discount_last_minute;
    }

    public List<Rezervare> getRezervare() {
        return rezervare;
    }

    public void setRezervare(List<Rezervare> rezervare) {
        this.rezervare = rezervare;
    }

    public float getPret_business() {
        return pret_business;
    }

    public void setPret_business(float pret_business) {
        this.pret_business = pret_business;
    }

    public float getPret_firstclass() {
        return pret_firstclass;
    }

    public void setPret_firstclass(float pret_firstclass) {
        this.pret_firstclass = pret_firstclass;
    }

    public Zbor() {
    }

    public Zbor(int id, int cod_zbor, int nr_locuri_total, LocalDate data_plecare, LocalDate ora_sosire, String nume_companie, String orasdus, String destinatie, int nr_locuri_seniori, int nr_locuri_adulti, int nr_locuri_copii, float pret_economy, int locuri_business, int locuri_economy, int lcouri_first, String zile_operare) {
        this.id = id;
        this.cod_zbor = cod_zbor;
        this.nr_locuri_total = nr_locuri_total;
        this.data_plecare = data_plecare;
        this.data_sosire = ora_sosire;
        this.nume_companie = nume_companie;
        this.orasdus = orasdus;
        this.destinatie = destinatie;
        this.nr_locuri_seniori = nr_locuri_seniori;
        this.nr_locuri_adulti = nr_locuri_adulti;
        this.nr_locuri_copii = nr_locuri_copii;
        this.pret_economy = pret_economy;
        this.locuri_business = locuri_business;
        this.locuri_economy = locuri_economy;
        this.locuri_first = lcouri_first;
        this.zile_operare = zile_operare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_zbor() {
        return cod_zbor;
    }

    public void setCod_zbor(int cod_zbor) {
        this.cod_zbor = cod_zbor;
    }

    public int getNr_locuri_total() {
        return nr_locuri_total;
    }

    public void setNr_locuri_total(int nr_locuri_total) {
        this.nr_locuri_total = nr_locuri_total;
    }

    public LocalDate getData_plecare() {
        return data_plecare;
    }

    public void setData_plecare(LocalDate ora_plecare) {
        this.data_plecare = ora_plecare;
    }

    public LocalDate getData_sosire() {
        return data_sosire;
    }

    public void setData_sosire(LocalDate ora_sosire) {
        this.data_sosire = ora_sosire;
    }

    public String getNume_companie() {
        return nume_companie;
    }

    public void setNume_companie(String nume_companie) {
        this.nume_companie = nume_companie;
    }

    public String getOrasdus() {
        return orasdus;
    }

    public void setOrasdus(String sursa) {
        this.orasdus = sursa;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public int getNr_locuri_seniori() {
        return nr_locuri_seniori;
    }

    public void setNr_locuri_seniori(int nr_locuri_seniori) {
        this.nr_locuri_seniori = nr_locuri_seniori;
    }

    public int getNr_locuri_adulti() {
        return nr_locuri_adulti;
    }

    public void setNr_locuri_adulti(int nr_locuri_adulti) {
        this.nr_locuri_adulti = nr_locuri_adulti;
    }

    public int getNr_locuri_copii() {
        return nr_locuri_copii;
    }

    public void setNr_locuri_copii(int nr_locuri_copii) {
        this.nr_locuri_copii = nr_locuri_copii;
    }

    public float getPret_economy() {
        return pret_economy;
    }

    public void setPret_economy(float pret) {
        this.pret_economy = pret;
    }

    public int getLocuri_business() {
        return locuri_business;
    }

    public void setLocuri_business(int locuri_business) {
        this.locuri_business = locuri_business;
    }

    public int getLocuri_economy() {
        return locuri_economy;
    }

    public void setLocuri_economy(int locuri_economy) {
        this.locuri_economy = locuri_economy;
    }

    public int getLocuri_first() {
        return locuri_first;
    }

    public void setLocuri_first(int locuri_first) {
        this.locuri_first = locuri_first;
    }

    public String getZile_operare() {
        return zile_operare;
    }

    public void setZile_operare(String zile_operare) {
        this.zile_operare = zile_operare;
    }
}
