package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
