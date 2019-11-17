package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.KennelReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KennelReservationRepository extends JpaRepository<KennelReservation, Integer> {
    @Query(value = "SELECT * FROM KENNEL_RESERVATION WHERE Pet_id= :petId", nativeQuery = true)
    List<KennelReservation> getReservationsByPet(@Param("petId") Integer petId);
}
