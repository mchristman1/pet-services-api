package com.petservices.api.petservicesapi.Controllers;

import com.petservices.api.petservicesapi.Exceptions.ResourceNotFoundException;
import com.petservices.api.petservicesapi.Models.Class;
import com.petservices.api.petservicesapi.Models.IdentityClasses.SectionIdentity;
import com.petservices.api.petservicesapi.Models.Section;
import com.petservices.api.petservicesapi.Models.Wrappers.SectionWrapper;
import com.petservices.api.petservicesapi.Repositories.ClassRepository;
import com.petservices.api.petservicesapi.Repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/section")
public class SectionController {

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    ClassRepository classRepository;

    //get all sections for class
    @GetMapping("/allForClass")
    public ResponseEntity<List<SectionWrapper>> getSectionsForClass(@RequestParam("classId") Integer classId) throws ResourceNotFoundException {
        Class pClass = classRepository.findById(classId).orElseThrow(() -> new ResourceNotFoundException("Class not found for id: " + classId));

        List<Section> sections = sectionRepository.getSectionByClass(classId);
        List<SectionWrapper> sectionWrappers = new ArrayList<>();

        for (Section section: sections) {
            sectionWrappers.add(new SectionWrapper(
                    section.getSectionIdentity(),
                    section.getClass_start(),
                    section.getClass_end(),
                    section.getClass_location(),
                    section.getClass_date(),
                    section.getStaff_id()));
        }

        return ResponseEntity.ok(sectionWrappers);
    }

    //get all sections for instructor
    @GetMapping("/allForStaff")
    public List<SectionWrapper> getSectionsForStaff(@RequestParam("staffId") Integer staffId) {
        List<Section> sections = sectionRepository.getSectionByStaff(staffId);
        List<SectionWrapper> sectionWrappers = new ArrayList<>();

        for (Section section: sections) {
            sectionWrappers.add(new SectionWrapper(
                    section.getSectionIdentity(),
                    section.getClass_start(),
                    section.getClass_end(),
                    section.getClass_location(),
                    section.getClass_date(),
                    section.getStaff_id()));
        }

        return sectionWrappers;

    }

    //new section
    @PostMapping(value = "/newSection", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public SectionWrapper newSection(SectionWrapper sectionWrapper, @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        SectionIdentity sectionIdentity = new SectionIdentity(sectionWrapper.getSection_id(), sectionWrapper.getClass_id());
        Section section = new Section(
                sectionIdentity,
                sectionWrapper.getClass_start(),
                sectionWrapper.getClass_end(),
                sectionWrapper.getClass_location(),
                date,
                sectionWrapper.getStaff_id()
        );

        Section sectionSaved = sectionRepository.save(section);

        return new SectionWrapper(
                sectionSaved.getSectionIdentity(),
                section.getClass_start(),
                sectionSaved.getClass_end(),
                sectionSaved.getClass_location(),
                sectionSaved.getClass_date(),
                sectionSaved.getStaff_id()
        );
    }

    //update section
    @PostMapping(value = "/updateSection", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<SectionWrapper> updateSection(SectionWrapper sectionWrapper, @DateTimeFormat(pattern = "yyyy-mm-dd") Date date) throws ResourceNotFoundException {
        Section section = sectionRepository.findById(new SectionIdentity(sectionWrapper.getSection_id(), sectionWrapper.getClass_id()))
                .orElseThrow(() -> new ResourceNotFoundException("Section not found for section id: " + sectionWrapper.getSection_id() + " and class id: " + sectionWrapper.getClass_id()));

        if(sectionWrapper.getClass_start() != null) {
            section.setClass_start(sectionWrapper.getClass_start());
        }

        if(sectionWrapper.getClass_end() != null) {
            section.setClass_end(sectionWrapper.getClass_end());
        }

        if(sectionWrapper.getClass_location() != null) {
            section.setClass_location(sectionWrapper.getClass_location());
        }

        if(sectionWrapper.getStaff_id() != null) {
            section.setStaff_id(sectionWrapper.getStaff_id());
        }

        if(date != null) {
            section.setClass_date(date);
        }

        SectionWrapper updatedSectionWrapper = new SectionWrapper(
                section.getSectionIdentity(),
                section.getClass_start(),
                section.getClass_end(),
                section.getClass_location(),
                section.getClass_date(),
                section.getStaff_id()
        );

        return ResponseEntity.ok(updatedSectionWrapper);
    }

    //delete section
    @DeleteMapping("/deleteSection")
    public ResponseEntity<String> deleteSection(@RequestParam("sectionId") String sectionId, @RequestParam("classId") Integer classId) throws ResourceNotFoundException {
        Section section = sectionRepository.findById(new SectionIdentity(sectionId, classId)).orElseThrow(() -> new ResourceNotFoundException("Section not found for Section Id: " + sectionId + " and Class id: " + classId));

        sectionRepository.delete(section);

        return ResponseEntity.ok("deleted");
    }

    @PostMapping(value = "/date", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Date dateTest(@DateTimeFormat(pattern = "yyyy-mm-dd") Date date) {
        return date;
    }
}
