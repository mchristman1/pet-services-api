package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Query(value = "SELECT * FROM PET WHERE Customer_id= :id", nativeQuery = true)
    List<Pet> findByCustomer(@Param("id") Integer id);
}
