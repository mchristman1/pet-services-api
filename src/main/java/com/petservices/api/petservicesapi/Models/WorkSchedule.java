package com.petservices.api.petservicesapi.Models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "WORK_SCHEDULE")
public class WorkSchedule {
    private Integer Schedule_id;
    private Date Schedule_date;
    private Time Shift_start;
    private Time Shift_end;
    private Integer Staff_id;

    public WorkSchedule() {}

    public WorkSchedule(Date schedule_date, Time shift_start, Time shift_end, Integer staff_id) {
        Schedule_date = schedule_date;
        Shift_start = shift_start;
        Shift_end = shift_end;
        Staff_id = staff_id;
    }

    @Id
    @Column(name = "Schedule_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getSchedule_id() {
        return Schedule_id;
    }
    public void setSchedule_id(Integer schedule_id) {
        Schedule_id = schedule_id;
    }

    @Column(name = "Schedule_date", nullable = false)
    public Date getSchedule_date() {
        return Schedule_date;
    }
    public void setSchedule_date(Date schedule_date) {
        Schedule_date = schedule_date;
    }

    @Column(name = "Shift_start", nullable = false)
    public Time getShift_start() {
        return Shift_start;
    }
    public void setShift_start(Time shift_start) {
        Shift_start = shift_start;
    }

    @Column(name = "Shift_end", nullable = false)
    public Time getShift_end() {
        return Shift_end;
    }
    public void setShift_end(Time shift_end) {
        Shift_end = shift_end;
    }

    @Column(name = "Staff_id", nullable = false)
    public Integer getStaff_id() {
        return Staff_id;
    }
    public void setStaff_id(Integer staff_id) {
        Staff_id = staff_id;
    }
}
