package com.petservices.api.petservicesapi.Models.IdentityClasses;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SectionIdentity implements Serializable {
    @Column(name = "Section_id", nullable = false)
    private String Section_id;

    @Column(name = "Class_id", nullable = false)
    private Integer Class_id;

    public SectionIdentity() {
    }

    public SectionIdentity(String section_id, Integer class_id) {
        Section_id = section_id;
        Class_id = class_id;
    }

    public String getSection_id() {
        return Section_id;
    }

    public void setSection_id(String section_id) {
        Section_id = section_id;
    }

    public Integer getClass_id() {
        return Class_id;
    }

    public void setClass_id(Integer class_id) {
        Class_id = class_id;
    }

    @Override
    public boolean equals(Object o) {
        if( this == o )  { return true; }
        SectionIdentity that = (SectionIdentity) o;

        return Objects.equals(getClass_id(), that.Class_id) && Objects.equals(getSection_id(), that.Section_id);
    }

    @Override
    public int hashCode() { return Objects.hash(getClass_id(), getSection_id()); }
}
