package com.fis.proiectFis.repositories;

import com.fis.proiectFis.entities.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Utilizator,Integer> {
    Utilizator findUtilizatorByNumeAndAndParola(String nume, String parola);
}
