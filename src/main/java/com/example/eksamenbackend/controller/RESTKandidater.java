package com.example.eksamenbackend.controller;

import com.example.eksamenbackend.model.Kandidater;
import com.example.eksamenbackend.repositories.KandidaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/Kandidater")
public class RESTKandidater {

    @Autowired
    KandidaterRepository kandidaterRepository;

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<Kandidater> createkandidater(@RequestBody Kandidater kandidater){

        kandidaterRepository.save(kandidater);

        return new ResponseEntity<>(kandidater, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Kandidater> displayKandidater(){
        return kandidaterRepository.findAll();
    }

    @PutMapping("/update/{kandidaterId}")
    public ResponseEntity<Kandidater> updateKandidater(@PathVariable int kandidaterId, @RequestBody Kandidater updatedKandidat){
        Optional<Kandidater> optionalObj = kandidaterRepository.findById(kandidaterId);
        Kandidater myObj = optionalObj.get();

        myObj.setName(updatedKandidat.getName());
        myObj.setAge(updatedKandidat.getAge());

        myObj = kandidaterRepository.save(myObj);

        return new ResponseEntity<>(myObj, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{kandidaterId}")
    public ResponseEntity<Kandidater> deleteKandidater(@PathVariable int kandidaterId){
        kandidaterRepository.deleteById(kandidaterId);

        return ResponseEntity.ok().build();
    }


}
