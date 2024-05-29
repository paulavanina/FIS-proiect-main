package com.fis.proiectFis.restAPI;

import com.fis.proiectFis.entities.Rezervare;
import com.fis.proiectFis.entities.Utilizator;
import com.fis.proiectFis.entities.Zbor;
import com.fis.proiectFis.repositories.RezervareRepo;
import com.fis.proiectFis.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class RestApiUser {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RezervareRepo rezervareRepo;

    @GetMapping("/getAll/user")
    public List<Utilizator> getAll(){
        return userRepo.findAll();
    }

    @PostMapping("/create/user")
    public void create(@RequestBody Utilizator utilizator){
        userRepo.save(utilizator);
    }

    @PutMapping("/update/user")
    public void update(@RequestBody Utilizator utilizator){
        userRepo.save(utilizator);}

    @DeleteMapping("/delete/user/{id}")
    public void delete(@PathVariable int id){
        userRepo.deleteById(id);
    }

    @GetMapping("/getUser/{username}/{parola}")
    public Utilizator loogedin(@PathVariable String username, @PathVariable String parola)
    {
        Utilizator utilizator=userRepo.findUtilizatorByNumeAndAndParola(username,parola);
        return utilizator;
    }

    @GetMapping("/getuserById/{id}")
    public Optional<Utilizator> getById(@PathVariable int id)
    {
        return userRepo.findById(id);
    }

    @PostMapping(path = "/create/rezervare/{id}")
    public void createFile(@PathVariable("id") int id) throws IOException {
        Optional<Utilizator> optionalUtilizator = userRepo.findById(id);
        if (optionalUtilizator.isPresent()) {
            Utilizator utilizator = optionalUtilizator.get();
            Rezervare rezervare = new Rezervare();
            rezervare.setUtilizator(utilizator);
            rezervareRepo.save(rezervare);
            utilizator.addRezervare(rezervare);
            userRepo.save(utilizator);
        } else {
            throw new IOException("User not found with id: " + id);
        }
    }

}
