package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<WorkSchedule, Integer> {

}
