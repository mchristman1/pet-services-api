package com.petservices.api.petservicesapi.Models;


import com.petservices.api.petservicesapi.Models.IdentityClasses.KennelIdentity;

import javax.persistence.*;

@Entity
@Table(name = "KENNEL")
public class Kennel {

    @EmbeddedId
    private KennelIdentity id;
    private Boolean isAvailable;

    public Kennel() {}

    public Kennel(KennelIdentity id, Boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
    }

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
