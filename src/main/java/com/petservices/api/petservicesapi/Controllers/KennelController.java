package com.petservices.api.petservicesapi.Controllers;

import com.petservices.api.petservicesapi.Exceptions.ResourceNotFoundException;
import com.petservices.api.petservicesapi.Models.Kennel;
import com.petservices.api.petservicesapi.Models.IdentityClasses.KennelIdentity;
import com.petservices.api.petservicesapi.Models.Wrappers.KennelWrapper;
import com.petservices.api.petservicesapi.Repositories.KennelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/kennel")
public class KennelController {
    @Autowired
    private KennelRepository kennelRepository;

    @GetMapping("/all")
    public List<KennelWrapper> getAllKennels() {
        List<Kennel> allKennels = kennelRepository.findAll();

        List<KennelWrapper> kennelWrappers = new ArrayList<>();

        for (Kennel kennel: allKennels) {
            kennelWrappers.add(new KennelWrapper(kennel.getId(), kennel.getAvailable()));
        }

        return kennelWrappers;
    }

    //Search by room
    @GetMapping("/getKennelsByRoom")
    public List<KennelWrapper> getKennelsByRoom(@RequestParam("dnumber") Integer dnumber, @RequestParam("buildingNumber") Integer buildingNumber, @RequestParam("roomNumber") Integer roomNumber) {
        List<Kennel> kennels = kennelRepository.findByRoom(dnumber, buildingNumber, roomNumber);

        List<KennelWrapper> kennelWrappers = new ArrayList<>();

        for (Kennel kennel: kennels) {
            kennelWrappers.add(new KennelWrapper(kennel.getId(), kennel.getAvailable()));
        }

        return kennelWrappers;
    }

    //Search by building
    @GetMapping("/getKennelsByBuilding")
    public List<KennelWrapper> getKennelsByRoom(@RequestParam("dnumber") Integer dnumber, @RequestParam("buildingNumber") Integer buildingNumber) {
        List<Kennel> kennels = kennelRepository.findByBuilding(dnumber, buildingNumber);

        List<KennelWrapper> kennelWrappers = new ArrayList<>();

        for (Kennel kennel: kennels) {
            kennelWrappers.add(new KennelWrapper(kennel.getId(), kennel.getAvailable()));
        }

        return kennelWrappers;
    }

    //Search by location
    @GetMapping("/getKennelsByLocation")
    public List<KennelWrapper> getKennelsByLocation(@RequestParam("dnumber") Integer dnumber) {
        List<Kennel> kennels = kennelRepository.findByLocation(dnumber);

        List<KennelWrapper> kennelWrappers = new ArrayList<>();

        for (Kennel kennel: kennels) {
            kennelWrappers.add(new KennelWrapper(kennel.getId(), kennel.getAvailable()));
        }

        return kennelWrappers;
    }

    @PostMapping(value = "/newKennel", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public KennelWrapper newKennel(KennelWrapper kennelWrapper) {

        KennelIdentity kennelIdentity = new KennelIdentity(kennelWrapper.getKennel_Id(),
                kennelWrapper.getBuilding_Number(),
                kennelWrapper.getRoom_Number(),
                kennelWrapper.getDnumber());

        Kennel kennel = kennelRepository.save(new Kennel(kennelIdentity, kennelWrapper.getAvailable()));

        return new KennelWrapper(kennel.getId(), kennel.getAvailable());
    }

    @PostMapping(value = "/updateKennel", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public KennelWrapper updateKennel(KennelWrapper kennelWrapper) {

        KennelIdentity kennelIdentity = new KennelIdentity(kennelWrapper.getKennel_Id(),
                kennelWrapper.getBuilding_Number(),
                kennelWrapper.getRoom_Number(),
                kennelWrapper.getDnumber());

        Kennel kennel = kennelRepository.save(new Kennel(kennelIdentity, kennelWrapper.getAvailable()));

        return new KennelWrapper(kennel.getId(), kennel.getAvailable());
    }

    @PostMapping(value = "/deleteKennel", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> deleteKennel(KennelIdentity kennelIdentity) throws ResourceNotFoundException {

        Kennel kennel = kennelRepository.findById(kennelIdentity).orElseThrow(() -> new ResourceNotFoundException("Kennel not found for id: " + kennelIdentity.toString()));

        kennelRepository.delete(kennel);

        return ResponseEntity.ok("deleted");
    }
}
