package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.ClassReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassReservationRepository extends JpaRepository<ClassReservation, Integer> {
    @Query(value = "SELECT * FROM CLASS_RESERVATION WHERE Pet_id= :petId", nativeQuery = true)
    List<ClassReservation> getReservationsByPet(@Param("petId") Integer petId);
}
