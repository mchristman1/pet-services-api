package com.petservices.api.petservicesapi.Models;

import javax.persistence.*;

@Entity
@Table(name = "CLASS")
public class Class {
    private Integer Class_id;
    private String Class_name;
    private String Class_desc;

    public Class() {}

    public Class(Integer class_id, String class_name, String class_desc) {
        this.Class_id = class_id;
        this.Class_name = class_name;
        this.Class_desc = class_desc;
    }

    @Id
    @Column(name = "Class_id", nullable = false)
    public Integer getClass_id() {
        return Class_id;
    }
    public void setClass_id(Integer class_id) {
        Class_id = class_id;
    }

    @Column(name = "Class_name", nullable = false)
    public String getClass_name() {
        return Class_name;
    }
    public void setClass_name(String class_name) {
        Class_name = class_name;
    }

    @Column(name = "Class_desc", nullable = false)
    public String getClass_desc() {
        return Class_desc;
    }
    public void setClass_desc(String class_desc) {
        Class_desc = class_desc;
    }
}
