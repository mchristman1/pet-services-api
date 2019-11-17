package com.petservices.api.petservicesapi.Controllers;

import com.petservices.api.petservicesapi.Exceptions.ResourceNotFoundException;
import com.petservices.api.petservicesapi.Models.ClassReservation;
import com.petservices.api.petservicesapi.Models.Customer;
import com.petservices.api.petservicesapi.Models.KennelReservation;
import com.petservices.api.petservicesapi.Models.Pet;
import com.petservices.api.petservicesapi.Repositories.ClassReservationRepository;
import com.petservices.api.petservicesapi.Repositories.CustomerRepository;
import com.petservices.api.petservicesapi.Repositories.KennelReservationRepository;
import com.petservices.api.petservicesapi.Repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    KennelReservationRepository kennelReservationRepository;

    @Autowired
    ClassReservationRepository classReservationRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PetRepository petRepository;

    @GetMapping("/class/all")
    public List<ClassReservation> getAllClassReservation() {
        return classReservationRepository.findAll();
    }

    @GetMapping("/class/getReservationByCustomer")
    public List<ClassReservation> getClassReservationByCustomer(@RequestParam("email") String email) {
        List<Customer> allCustomers = customerRepository.findByEmail(email);
        if(allCustomers.isEmpty()) {
            return new ArrayList<>();
        }

        Customer customer = allCustomers.get(0);

        List<Pet> allPets = petRepository.findByCustomer(customer.getCustomer_id());
        List<ClassReservation> classReservations = new ArrayList<>();

        for (Pet pet: allPets) {
            classReservations.addAll(classReservationRepository.getReservationsByPet(pet.getPet_id()));
        }

        return classReservations;
    }

    @PostMapping(value = "/class/newReservation", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ClassReservation newClassReservation(@DateTimeFormat(pattern = "yyyy-mm-dd") Date rdate, ClassReservation classReservation) {

        System.out.println("\n\n\n----- " + rdate + " ---------\n\n\n");

        classReservation.setDate(rdate);

        return classReservationRepository.save(classReservation);
    }

    @DeleteMapping("/class/cancelReservation")
    public ResponseEntity<String> cancelClassReservation(@RequestParam("id") Integer reservationId) throws ResourceNotFoundException {
        ClassReservation classReservation = classReservationRepository.findById(reservationId).orElseThrow(() -> new ResourceNotFoundException("Reservation not found for id: " + reservationId));

        classReservationRepository.delete(classReservation);

        return ResponseEntity.ok("cancelled");
    }

    @GetMapping("/kennel/all")
    public List<KennelReservation> getAllKennelReservation() {
        return kennelReservationRepository.findAll();
    }

    @PostMapping(value = "/kennel/newReservation", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public KennelReservation newKennelReservation(@DateTimeFormat(pattern = "yyyy-mm-dd") Date startDate, @DateTimeFormat(pattern = "yyyy-mm-dd") Date endDate, KennelReservation kennelReservation) {

        kennelReservation.setReservation_start(startDate);
        kennelReservation.setReservation_end(endDate);

        return kennelReservationRepository.save(kennelReservation);
    }

    @DeleteMapping("/kennel/cancelReservation")
    public ResponseEntity<String> cancelKennelReservation(@RequestParam("id") Integer reservationId) throws ResourceNotFoundException {
        KennelReservation kennelReservation = kennelReservationRepository.findById(reservationId).orElseThrow(() -> new ResourceNotFoundException("Reservation not found for id: " + reservationId));

        kennelReservationRepository.delete(kennelReservation);

        return ResponseEntity.ok("cancelled");
    }

    @GetMapping("/kennel/getKennelReservationByCustomer")
    public List<KennelReservation> getKennelReservationByCustomer(@RequestParam("email") String email) {
        List<Customer> allCustomers = customerRepository.findByEmail(email);
        if(allCustomers.isEmpty()) {
            return new ArrayList<>();
        }

        Customer customer = allCustomers.get(0);

        List<Pet> allPets = petRepository.findByCustomer(customer.getCustomer_id());
        List<KennelReservation> kennelReservations = new ArrayList<>();

        for (Pet pet: allPets) {
            kennelReservations.addAll(kennelReservationRepository.getReservationsByPet(pet.getPet_id()));
        }

        return kennelReservations;
    }
}
