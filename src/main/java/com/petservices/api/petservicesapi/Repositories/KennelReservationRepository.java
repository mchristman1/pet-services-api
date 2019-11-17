package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.KennelReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KennelReservationRepository extends JpaRepository<KennelReservation, Integer> {
}
