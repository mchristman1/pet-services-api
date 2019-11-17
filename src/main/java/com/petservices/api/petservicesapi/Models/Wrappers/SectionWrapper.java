package com.petservices.api.petservicesapi.Models.Wrappers;

import com.petservices.api.petservicesapi.Models.IdentityClasses.SectionIdentity;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SectionWrapper {
    private String Section_id;
    private Integer Class_id;
    private Time Class_start;
    private Time Class_end;
    private String Class_location;
    private Date Class_date;
    private Integer Staff_id;

    public SectionWrapper() {
    }

    public SectionWrapper(String section_id, Integer class_id, Time class_start, Time class_end, String class_location, Date class_date, Integer staff_id) {
        Section_id = section_id;
        Class_id = class_id;
        Class_start = class_start;
        Class_end = class_end;
        Class_location = class_location;
        Class_date = class_date;
        Staff_id = staff_id;
    }

    public SectionWrapper(SectionIdentity sectionIdentity, Time class_start, Time class_end, String class_location, Date class_date, Integer staff_id) {
        Section_id = sectionIdentity.getSection_id();
        Class_id = sectionIdentity.getClass_id();
        Class_start = class_start;
        Class_end = class_end;
        Class_location = class_location;
        Class_date = class_date;
        Staff_id = staff_id;
    }

    public String getSection_id() {
        return Section_id;
    }

    public void setSection_id(String section_id) {
        Section_id = section_id;
    }

    public Integer getClass_id() {
        return Class_id;
    }

    public void setClass_id(Integer class_id) {
        Class_id = class_id;
    }

    public Time getClass_start() {
        return Class_start;
    }

    public void setClass_start(Time class_start) {
        Class_start = class_start;
    }

    public Time getClass_end() {
        return Class_end;
    }

    public void setClass_end(Time class_end) {
        Class_end = class_end;
    }

    public String getClass_location() {
        return Class_location;
    }

    public void setClass_location(String class_location) {
        Class_location = class_location;
    }

    public Date getClass_date() {
        return Class_date;
    }

    public void setClass_date(Date class_date) {
        Class_date = class_date;
    }

    public Integer getStaff_id() {
        return Staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        Staff_id = staff_id;
    }
}
