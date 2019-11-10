package com.petservices.api.petservicesapi.Models;

import javax.persistence.*;

@Entity
@Table(name = "STAFF")
public class Staff {
    private Integer Staff_id;
    private String Fname;
    private String Lname;
    private String Job_title;
    private Integer Department_id;
    private String Address;

    public Staff() {}

    public Staff(String fname, String lname, String job_title, Integer department_id, String address) {
        this.Fname = fname;
        this.Lname = lname;
        this.Job_title = job_title;
        this.Department_id = department_id;
        this.Address = address;
    }

    @Id
    @Column(name = "Staff_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getStaff_id() {
        return Staff_id;
    }
    public void setStaff_id(Integer staff_id) {
        Staff_id = staff_id;
    }

    @Column(name = "Fname", nullable = false)
    public String getFname() {
        return Fname;
    }
    public void setFname(String fname) {
        Fname = fname;
    }

    @Column(name = "Lname", nullable = false)
    public String getLname() {
        return Lname;
    }
    public void setLname(String lname) {
        Lname = lname;
    }

    @Column(name = "Job_title", nullable = false)
    public String getJob_title() {
        return Job_title;
    }
    public void setJob_title(String job_title) {
        Job_title = job_title;
    }

    @Column(name = "Department_id", nullable = false)
    public Integer getDepartment_id() {
        return Department_id;
    }
    public void setDepartment_id(Integer department_id) {
        Department_id = department_id;
    }

    @Column(name = "Address", nullable = false)
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
}
