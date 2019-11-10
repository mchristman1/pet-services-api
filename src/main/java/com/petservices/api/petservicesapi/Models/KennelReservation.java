package com.petservices.api.petservicesapi.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "KENNEL_RESERVATION")
public class KennelReservation {
    private Integer Reservation_id;
    private Integer Dnum;
    private Integer Room_number;
    private Date Reservation_start;
    private Date Reservation_end;
    private Integer Pet_id;
    private Integer Kennel_id;
    private Integer Building_number;

    public KennelReservation() {}

    public KennelReservation(Integer dnum, Integer room_number, Date reservation_start, Date reservation_end, Integer pet_id, Integer kennel_id, Integer building_number) {
        this.Dnum = dnum;
        this.Room_number = room_number;
        this.Reservation_start = reservation_start;
        this.Reservation_end = reservation_end;
        this.Pet_id = pet_id;
        this.Kennel_id = kennel_id;
        this.Building_number = building_number;
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

    @Column(name = "Dnum", nullable = false)
    public Integer getDnum() {
        return Dnum;
    }
    public void setDnum(Integer dnum) {
        Dnum = dnum;
    }

    @Column(name = "Room_number", nullable = false)
    public Integer getRoom_number() {
        return Room_number;
    }
    public void setRoom_number(Integer room_number) {
        Room_number = room_number;
    }

    @Column(name = "Reservation_start", nullable = false)
    public Date getReservation_start() {
        return Reservation_start;
    }
    public void setReservation_start(Date reservation_start) {
        Reservation_start = reservation_start;
    }

    @Column(name = "Reservation_end", nullable = false)
    public Date getReservation_end() {
        return Reservation_end;
    }
    public void setReservation_end(Date reservation_end) {
        Reservation_end = reservation_end;
    }

    @Column(name = "Pet_id", nullable = false)
    public Integer getPet_id() {
        return Pet_id;
    }
    public void setPet_id(Integer pet_id) {
        Pet_id = pet_id;
    }

    @Column(name = "Kennel_id", nullable = false)
    public Integer getKennel_id() {
        return Kennel_id;
    }
    public void setKennel_id(Integer kennel_id) {
        Kennel_id = kennel_id;
    }

    @Column(name = "Building_number", nullable = false)
    public Integer getBuilding_number() {
        return Building_number;
    }
    public void setBuilding_number(Integer building_number) {
        Building_number = building_number;
    }
}
