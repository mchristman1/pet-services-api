package com.petservices.api.petservicesapi.Models;

import javax.persistence.*;
import java.math.BigInteger;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    private Integer Customer_id;
    private String Email;
    private String Fname;
    private String Lname;
    private BigInteger Phone_Number;

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

    public Customer() {}

    public Customer(String email, String fname, String lname, BigInteger phone_number) {
        this.Fname = fname;
        this.Lname = lname;
        this.Email = email;
        this.Phone_Number = phone_number;
    }

    @Id
    @Column(name = "Customer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCustomer_id() {
        return Customer_id;
    }
    public void setCustomer_id(Integer id) {
        this.Customer_id = id;
    }

    @Column(name = "Email", nullable = false)
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
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

    @Column(name = "Phone_Number", nullable = false)
    public BigInteger getPhone_Number() {
        return Phone_Number;
    }
    public void setPhone_Number(BigInteger phone_number) {
        Phone_Number = phone_number;
    }

    @Override
    public String toString() {
        return "Customer { Customer_id=" + Customer_id + ", Email=" + Email + ", Fname=" + Fname + ", Lname=" + Lname
                + ", Phone_Number=" + Phone_Number + "}";
    }
}
