package com.fis.proiectFis.restAPI;

import com.fis.proiectFis.entities.Rezervare;
import com.fis.proiectFis.entities.Utilizator;
import com.fis.proiectFis.entities.Zbor;
import com.fis.proiectFis.repositories.ZborRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestApi {

    @Autowired
    ZborRepo zborRepo;

    @GetMapping("/getAll/zbor")
    public List<Zbor> getAll(){
        return zborRepo.findAll();
    }

    @PostMapping("/create/zbor")
    public void create(@RequestBody Zbor zbor){
       zborRepo.save(zbor);
    }

    @PutMapping("/update/zbor")
    public void update(@RequestBody Zbor zbor){
        zborRepo.save(zbor);}

    @DeleteMapping("/delete/zbor/{id}")
    public void delete(@PathVariable int id){
        zborRepo.deleteById(id);
    }

    @GetMapping("/getZbor/{oras_dus}/{oras_intors}")
    public List <Zbor> searchFlight(@PathVariable String oras_dus, @PathVariable String oras_intors)
    {
        System.out.println("ratatatata");

        return zborRepo.findZborsByOrasdusAndDestinatie(oras_dus,oras_intors);
    }

    @GetMapping("/getzborById/{id}")
    public Optional<Zbor> getById(@PathVariable int id)
    {
        return zborRepo.findById(id);
    }
}
