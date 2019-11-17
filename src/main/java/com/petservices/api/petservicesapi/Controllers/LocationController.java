package com.petservices.api.petservicesapi.Controllers;

import com.petservices.api.petservicesapi.Exceptions.ResourceNotFoundException;
import com.petservices.api.petservicesapi.Models.Location;
import com.petservices.api.petservicesapi.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/all")
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/getLocationById")
    public ResponseEntity<Location> getLocationById(@RequestParam("id") Integer id) throws ResourceNotFoundException {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found for id: " + id));

        return ResponseEntity.ok(location);
    }

    @PostMapping(value = "/updateLocation", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Location> updateLocation(@RequestParam("id") Integer id, Location locationDetails) throws ResourceNotFoundException {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location not found for id: " + id));

        location.setDlocation(locationDetails.getDlocation());

        Location updatedLocation = locationRepository.save(location);
        return ResponseEntity.ok(updatedLocation);
    }

    @PostMapping(value = "/newLocation", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Location newLocation(Location location) {
        return locationRepository.save(location);
    }
}
