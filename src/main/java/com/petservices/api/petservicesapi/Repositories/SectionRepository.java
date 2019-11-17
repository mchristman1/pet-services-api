package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.IdentityClasses.SectionIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.petservices.api.petservicesapi.Models.Section;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, SectionIdentity> {
    @Query(value = "SELECT * FROM SECTION WHERE Class_id= :classId", nativeQuery = true)
    List<Section> getSectionByClass(@Param("classId") Integer classId);

    @Query(value = "SELECT * FROM SECTION WHERE Staff_id= :staffId", nativeQuery = true)
    List<Section> getSectionByStaff(@Param("staffId") Integer staffId);
}
