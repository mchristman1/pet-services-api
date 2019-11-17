package com.petservices.api.petservicesapi.Controllers;

import com.petservices.api.petservicesapi.Exceptions.ResourceNotFoundException;
import com.petservices.api.petservicesapi.Repositories.ClassRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.petservices.api.petservicesapi.Models.Class;

import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassController {
    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/all")
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    @GetMapping("/getClassById")
    public ResponseEntity<Class> getClassById(@RequestParam(value = "id") Integer id) throws ResourceNotFoundException {
        Class pClass = classRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Class not found for id: " + id));

        return ResponseEntity.ok(pClass);
    }

    @GetMapping("/getClassByName")
    public List<Class> getClassByName(@RequestParam(value = "name") String name) {
        return classRepository.getClassByName(name);
    }

    @PostMapping(value = "/newClass", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Class newClass(Class pClass) {
        return classRepository.save(pClass);
    }

    @PostMapping(value = "/updateClass", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Class> updateClass(@RequestParam("id") Integer id, Class pClassDetails) throws ResourceNotFoundException {
        Class pClass = classRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Class not found for id: " + id));

        if(pClassDetails.getClass_name() != null) {
            pClass.setClass_name(pClassDetails.getClass_name());
        }

        if(pClassDetails.getClass_desc() != null) {
            pClass.setClass_desc(pClassDetails.getClass_desc());
        }

        Class updatedClass = classRepository.save(pClass);

        return ResponseEntity.ok(updatedClass);
    }

    @DeleteMapping(value = "/deleteClass")
    public ResponseEntity<String> deleteClass(@RequestParam("id") Integer id) throws ResourceNotFoundException {
        Class pClass = classRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Class not found for id: " + id));

        classRepository.delete(pClass);

        return ResponseEntity.ok("deleted");

    }
}
