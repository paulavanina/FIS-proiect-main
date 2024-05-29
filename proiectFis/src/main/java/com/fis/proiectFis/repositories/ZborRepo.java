package com.fis.proiectFis.repositories;

import com.fis.proiectFis.entities.Zbor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZborRepo extends JpaRepository<Zbor,Integer> {
   List <Zbor> findZborsByOrasdusAndDestinatie(String orasdus, String destinatie);
//   List <Zbor> findZborsByOrasdusAndDestinatieAAndData_plecareAndAndData_sosire(String orasdus, String destinatie);
   List <Zbor> findZborsByOrasdus(String orasdus);
}
