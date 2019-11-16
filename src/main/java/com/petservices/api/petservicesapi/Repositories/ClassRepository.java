package com.petservices.api.petservicesapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.petservices.api.petservicesapi.Models.Class;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {
    @Query(value = "SELECT * FROM CLASS WHERE Class_name= :name", nativeQuery = true)
    List<Class> getClassByName(@Param("name") String name);
}
