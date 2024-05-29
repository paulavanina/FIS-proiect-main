package com.fis.proiectFis.restAPI;

import com.fis.proiectFis.entities.Rezervare;
import com.fis.proiectFis.repositories.RezervareRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApiRezervare {

    @Autowired
    RezervareRepo rezervareRepo;

    @GetMapping("/getAll/rezervare")
    public List<Rezervare> getAll(){
        return rezervareRepo.findAll();
    }

    @PostMapping("/create/rezervare")
    public void create_rezervare(@RequestBody Rezervare rezervare){
        rezervareRepo.save(rezervare);
       /* String to = rezervare.getEmail();
        String subject = "Rezervare realizată cu succes";
        String text = "Detalii zbor:\n" +
                "Cod zbor: " + rezervare.getCod_zbor() + "\n" +
                "Oraș de plecare: " + rezervare.getOras_dus() + "\n" +
                "Destinație: " + rezervare.getOras_intors() + "\n" +
                "Ora plecării: " + rezervare.getData_plecare() + "\n" +
                "Ora sosirii: " + rezervare.getData_sosire() + "\n" +
                "Număr locuri: " + rezervare.getNr_locuri_adulti();

        emailService.sendEmail(to, subject, text);*/
    }


    @DeleteMapping("/delete/rezervare/{id}")
    public void delete_rezervare(@PathVariable int id)
    {
        rezervareRepo.deleteById(id);
    }

    @PutMapping("/update/rezervare")
    public void update(@RequestBody Rezervare rezervare){
        rezervareRepo.save(rezervare);}


}
