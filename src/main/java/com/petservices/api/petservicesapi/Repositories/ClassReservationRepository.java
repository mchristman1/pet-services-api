package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.ClassReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassReservationRepository extends JpaRepository<ClassReservation, Integer> {

}
