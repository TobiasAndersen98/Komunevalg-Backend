package com.example.eksamenbackend.controller;

import com.example.eksamenbackend.model.Party;
import com.example.eksamenbackend.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/party")
public class RESTParty {

    @Autowired
    PartyRepository partyRepository;

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<Party> createParty(@RequestBody Party party){

        partyRepository.save(party);

        return new ResponseEntity<>(party, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Party> displayParty(){

        return partyRepository.findAll();
    }

    @PutMapping("/update/{partyId}")
    public ResponseEntity<Party> updateParty(@PathVariable int partyId, @RequestBody Party updatParty){

        Optional<Party> optionalObj = partyRepository.findById(partyId);
        Party partyObj = optionalObj.get();

        partyObj.setName(updatParty.getName());

        partyObj = partyRepository.save(partyObj);

        return new ResponseEntity<>(partyObj,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{partyId}")
    public ResponseEntity<Party> deleteParty(@PathVariable int partyId){

        partyRepository.deleteById(partyId);

        return ResponseEntity.ok().build();
    }


}
