package com.petservices.api.petservicesapi.Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KennelIdentity implements Serializable {
    @Column(name = "Kennel_Id", nullable = false)
    private Integer Kennel_Id;

    @Column(name = "Building_Number", nullable = false)
    private Integer Building_Number;

    @Column(name = "Room_Number", nullable = false)
    private Integer Room_Number;

    @Column(name = "Dnumber", nullable = false)
    private Integer Dnumber;

    public KennelIdentity() {
    }

    public KennelIdentity(Integer kennel_Id, Integer building_Number, Integer room_Number, Integer dnumber) {
        Kennel_Id = kennel_Id;
        Building_Number = building_Number;
        Room_Number = room_Number;
        Dnumber = dnumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof KennelIdentity)) { return false; }
        KennelIdentity that = (KennelIdentity) o;
        return Objects.equals(getKennel_Id(), that.getKennel_Id())
                && Objects.equals(getBuilding_Number(), that.getBuilding_Number())
                && Objects.equals(getRoom_Number(), that.getRoom_Number())
                && Objects.equals(getDnumber(), that.getDnumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKennel_Id(), getBuilding_Number(), getRoom_Number(), getDnumber());
    }
}
