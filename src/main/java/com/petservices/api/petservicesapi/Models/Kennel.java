package com.petservices.api.petservicesapi.Models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
//@IdClass(Kennel.IdClass.class)
@Table(name = "KENNEL")
public class Kennel {

//    @Id
//    private Integer Kennel_Id;
//
//    @Id
//    private Integer Building_Number;
//
//    @Id
//    private Integer Room_Number;
//
//    @Id
//    private Integer Dnumber;
    @EmbeddedId
    private KennelIdentity id;
    private Boolean isAvailable;

    public Kennel() {}

    public Kennel(KennelIdentity id, Boolean isAvailable) {
//        this.Kennel_Id = kennel_id;
//        this.Building_Number = building_number;
//        this.Room_Number = room_number;
//        this.Dnumber = dnumber;
        this.id = id;
        this.isAvailable = isAvailable;
    }

//    static class IdClass implements Serializable {
//        private Integer Kennel_Id;
//        private Integer Building_Number;
//        private Integer Room_Number;
//        private Integer Dnumber;
//    }

//   @Column(name = "Kennel_Id", nullable = false)
//    public Integer getKennel_Id() {
//        return Kennel_Id;
//    }
//    public void setKennel_Id(Integer kennel_Id) {
//        Kennel_Id = kennel_Id;
//    }
//
//    @Column(name = "Building_Number", nullable = false)
//    public Integer getBuilding_Number() {
//        return Building_Number;
//    }
//    public void setBuilding_Number(Integer building_Number) {
//        Building_Number = building_Number;
//    }
//
//    @Column(name = "Room_Number", nullable = false)
//    public Integer getRoom_Number() {
//        return Room_Number;
//    }
//    public void setRoom_Number(Integer room_Number) {
//        Room_Number = room_Number;
//    }
//
//    @Column(name = "Dnumber", nullable = false)
//    public Integer getDnumber() {
//        return Dnumber;
//    }
//    public void setDnumber(Integer dnumber) {
//        Dnumber = dnumber;
//    }

    public KennelIdentity getId() {
        return id;
    }

    public void setId(KennelIdentity id) {
        this.id = id;
    }

    @Column(name = "isAvailable", nullable = false)
    public Boolean getAvailable() {
        return isAvailable;
    }
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
