package com.petservices.api.petservicesapi.Models;

import com.petservices.api.petservicesapi.Models.IdentityClasses.SectionIdentity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "SECTION")
public class Section {

    @EmbeddedId
    private SectionIdentity sectionIdentity;

    private Time Class_start;
    private Time Class_end;
    private String Class_location;
    private Date Class_date;
    private Integer Staff_id;

    public Section() {
    }

    public Section(SectionIdentity sectionIdentity, Time class_start, Time class_end, String class_location, Date class_date, Integer staff_id) {
        this.sectionIdentity = sectionIdentity;
        Class_start = class_start;
        Class_end = class_end;
        Class_location = class_location;
        Class_date = class_date;
        Staff_id = staff_id;
    }

    public SectionIdentity getSectionIdentity() {
        return sectionIdentity;
    }

    public void setSectionIdentity(SectionIdentity sectionIdentity) {
        this.sectionIdentity = sectionIdentity;
    }

    @Column(name = "Class_start", nullable = false)
    public Time getClass_start() {
        return Class_start;
    }

    public void setClass_start(Time class_start) {
        Class_start = class_start;
    }

    @Column(name = "Class_end", nullable = false)
    public Time getClass_end() {
        return Class_end;
    }

    public void setClass_end(Time class_end) {
        Class_end = class_end;
    }

    @Column(name = "Class_location", nullable = false)
    public String getClass_location() {
        return Class_location;
    }

    public void setClass_location(String class_location) {
        Class_location = class_location;
    }

    @Column(name = "Class_date", nullable = false)
    public Date getClass_date() {
        return Class_date;
    }

    public void setClass_date(Date class_date) {
        Class_date = class_date;
    }

    @Column(name = "Staff_id", nullable = false)
    public Integer getStaff_id() {
        return Staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        Staff_id = staff_id;
    }
}
