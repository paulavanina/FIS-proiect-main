package com.fis.proiectFis.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String parola;
    private String email;
    private String nume;
    private String rol;


    //@JsonIgnore
    @OneToMany(mappedBy = "utilizator",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Rezervare> rezervare;

    public Utilizator() {
    }

    public List<Rezervare> getRezervare() {
        return rezervare;
    }

    public void setRezervare(List<Rezervare> rezervare) {
        this.rezervare = rezervare;
    }

    public Utilizator(int id, String parola, String email, String nume, String rol) {
        this.id = id;
        this.parola = parola;
        this.email = email;
        this.nume = nume;
        this.rol = rol;
    }

    public void addRezervare(Rezervare rezervare)
    {
        if (this.rezervare==null) {this.rezervare=new ArrayList<>();}
        this.rezervare.add(rezervare);
        rezervare.setUtilizator(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
