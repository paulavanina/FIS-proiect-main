package com.fis.proiectFis.repositories;

import com.fis.proiectFis.entities.Rezervare;
import com.fis.proiectFis.entities.Zbor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezervareRepo extends JpaRepository<Rezervare,Integer> {

}
