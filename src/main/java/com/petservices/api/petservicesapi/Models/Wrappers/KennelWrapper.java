package com.petservices.api.petservicesapi.Models.Wrappers;

import com.petservices.api.petservicesapi.Models.IdentityClasses.KennelIdentity;

public class KennelWrapper {

    private Integer Kennel_Id;
    private Integer Building_Number;
    private Integer Room_Number;
    private Integer Dnumber;
    private Boolean isAvailable;

    public KennelWrapper() {}

    public KennelWrapper(Integer kennel_Id, Integer building_Number, Integer room_Number, Integer dnumber, Boolean isAvailable) {
        this.Kennel_Id = kennel_Id;
        this.Building_Number = building_Number;
        this.Room_Number = room_Number;
        this.Dnumber = dnumber;
        this.isAvailable = isAvailable;
    }

    public KennelWrapper(KennelIdentity kennelIdentity, Boolean isAvilable) {
        this.Kennel_Id = kennelIdentity.getKennel_Id();
        this.Building_Number = kennelIdentity.getBuilding_Number();
        this.Room_Number = kennelIdentity.getRoom_Number();
        this.Dnumber = kennelIdentity.getDnumber();
        this.isAvailable = isAvilable;
    }


    public Integer getKennel_Id() {
        return Kennel_Id;
    }

    public void setKennel_Id(Integer kennel_Id) {
        Kennel_Id = kennel_Id;
    }

    public Integer getBuilding_Number() {
        return Building_Number;
    }

    public void setBuilding_Number(Integer building_Number) {
        Building_Number = building_Number;
    }

    public Integer getRoom_Number() {
        return Room_Number;
    }

    public void setRoom_Number(Integer room_Number) {
        Room_Number = room_Number;
    }

    public Integer getDnumber() {
        return Dnumber;
    }

    public void setDnumber(Integer dnumber) {
        Dnumber = dnumber;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return " Kennel Wrapper ( " + Kennel_Id + ", " + Building_Number + ", " + Room_Number + ", " + Dnumber + ", " + isAvailable + " )";
    }
}
