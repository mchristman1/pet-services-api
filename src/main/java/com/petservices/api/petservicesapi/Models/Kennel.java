package com.petservices.api.petservicesapi.Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KENNEL")
public class Kennel {
    private Integer Kennel_Id;
    private Integer Building_Number;
    private Integer Room_Number;
    private Integer Dnumber;
    private Boolean isAvailable;

    public Kennel() {}

    public Kennel(Integer kennel_Id, Integer building_Number, Integer room_Number, Integer dnumber, Boolean isAvailable) {
        this.Kennel_Id = kennel_Id;
        this.Building_Number = building_Number;
        this.Room_Number = room_Number;
        this.Dnumber = dnumber;
        this.isAvailable = isAvailable;
    }

    @Id
    @Column(name = "Kennel_Id", nullable = false)
    public Integer getKennel_Id() {
        return Kennel_Id;
    }
    public void setKennel_Id(Integer kennel_Id) {
        Kennel_Id = kennel_Id;
    }

    @Id
    @Column(name = "Building_Number", nullable = false)
    public Integer getBuilding_Number() {
        return Building_Number;
    }
    public void setBuilding_Number(Integer building_Number) {
        Building_Number = building_Number;
    }

    @Id
    @Column(name = "Room_Number", nullable = false)
    public Integer getRoom_Number() {
        return Room_Number;
    }
    public void setRoom_Number(Integer room_Number) {
        Room_Number = room_Number;
    }

    @Id
    @Column(name = "Dnumber", nullable = false)
    public Integer getDnumber() {
        return Dnumber;
    }
    public void setDnumber(Integer dnumber) {
        Dnumber = dnumber;
    }

    @Column(name = "isAvailable", nullable = false)
    public Boolean getAvailable() {
        return isAvailable;
    }
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
