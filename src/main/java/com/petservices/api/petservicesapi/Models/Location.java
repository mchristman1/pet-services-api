package com.petservices.api.petservicesapi.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATIONS")
public class Location {
    private Integer Dnumber;
    private String Dlocation;

    public Location() {}

    public Location(Integer dnumber, String dlocation) {
        this.Dnumber = dnumber;
        this.Dlocation = dlocation;
    }

    @Id
    @Column(name = "Dnumber", nullable = false )
    public Integer getDnumber() {
        return Dnumber;
    }
    public void setDnumber(Integer dnumber) {
        Dnumber = dnumber;
    }

    @Column(name = "Dlocation", nullable = false)
    public String getDlocation() {
        return Dlocation;
    }
    public void setDlocation(String dlocation) {
        Dlocation = dlocation;
    }
}
