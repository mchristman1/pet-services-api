package com.petservices.api.petservicesapi.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CLASS_RESERVATION")
public class ClassReservation {
    private Integer Reservation_id;
    private String Section;
    private Integer Class_id;
    private Date Date;
    private Integer Pet_id;

    public ClassReservation() {}

    public ClassReservation(String section, Integer class_id, java.util.Date date, Integer pet_id) {
        this.Section = section;
        this.Class_id = class_id;
        this.Date = date;
        this.Pet_id = pet_id;
    }

    @Id
    @Column(name = "Reservation_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getReservation_id() {
        return Reservation_id;
    }
    public void setReservation_id(Integer reservation_id) {
        Reservation_id = reservation_id;
    }

    @Column(name = "Section", nullable = false)
    public String getSection() {
        return Section;
    }
    public void setSection(String section) {
        Section = section;
    }

    @Column(name = "Class_id", nullable = false)
    public Integer getClass_id() {
        return Class_id;
    }
    public void setClass_id(Integer class_id) {
        Class_id = class_id;
    }

    @Column(name = "Date", nullable = false)
    public java.util.Date getDate() {
        return Date;
    }
    public void setDate(java.util.Date date) {
        Date = date;
    }

    @Column(name = "Pet_id", nullable = false)
    public Integer getPet_id() {
        return Pet_id;
    }
    public void setPet_id(Integer pet_id) {
        Pet_id = pet_id;
    }
}
