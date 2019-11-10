package com.petservices.api.petservicesapi.Models;

import javax.persistence.*;

@Entity
@Table(name = "PET")
public class Pet {
    private Integer Pet_id;
    private Integer Customer_id;
    private String Pet_name;

    public Pet() {}

    public Pet(Integer customer_id, String pet_name) {
        this.Customer_id = customer_id;
        this.Pet_name = pet_name;
    }

    @Id
    @Column(name = "Pet_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getPet_id() {
        return Pet_id;
    }
    public void setPet_id(Integer pet_id) {
        Pet_id = pet_id;
    }

    @Column(name = "Customer_id", nullable = false)
    public Integer getCustomer_id() {
        return Customer_id;
    }
    public void setCustomer_id(Integer customer_id) {
        Customer_id = customer_id;
    }

    @Column(name = "Pet_name", nullable = false)
    public String getPet_name() {
        return Pet_name;
    }
    public void setPet_name(String pet_name) {
        Pet_name = pet_name;
    }
}
