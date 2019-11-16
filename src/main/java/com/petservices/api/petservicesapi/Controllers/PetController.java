package com.petservices.api.petservicesapi.Controllers;

import com.petservices.api.petservicesapi.Exceptions.ResourceNotFoundException;
import com.petservices.api.petservicesapi.Models.Pet;
import com.petservices.api.petservicesapi.Repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/pet")
public class PetController {
    @Autowired
    private PetRepository petRepository;

    @GetMapping("/all")
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @GetMapping(value = "/findById", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Pet getPetById(Integer id) throws ResourceNotFoundException {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pet not found for id: " + id));
        return pet;
    }


    @PostMapping(value = "/newPet", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Pet addNewPet(Pet pet) {
        return petRepository.save(pet);
    }

    @GetMapping(value = "/findByCustomer", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public List<Pet> getPetByCustomer(Integer id) {
        return petRepository.findByCustomer(id);
    }

    @DeleteMapping(value = "deletePet", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> deletePet(Integer id) throws  ResourceNotFoundException {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pet not found for id: " + id));

        petRepository.delete(pet);

        return ResponseEntity.ok("deleted");
    }

}
