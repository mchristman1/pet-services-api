package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.Kennel;
import com.petservices.api.petservicesapi.Models.IdentityClasses.KennelIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KennelRepository extends JpaRepository<Kennel, KennelIdentity> {
    @Query(value = "SELECT * FROM KENNEL WHERE Dnumber= :dnumber AND Building_Number= :buildingNumber AND Room_Number= :roomNumber", nativeQuery = true)
    List<Kennel> findByRoom(@Param("dnumber") Integer dnumber, @Param("buildingNumber") Integer buildingNumber, @Param("roomNumber")Integer roomNumber);

    @Query(value = "SELECT * FROM KENNEL WHERE Dnumber= :dnumber AND Building_Number= :buildingNumber", nativeQuery = true)
    List<Kennel> findByBuilding(@Param("dnumber") Integer dnumber, @Param("buildingNumber") Integer buildingNumber);
}
