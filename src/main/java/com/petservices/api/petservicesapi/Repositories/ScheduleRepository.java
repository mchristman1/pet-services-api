package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<WorkSchedule, Integer> {
    @Query(value = "SELECT * FROM WORK_SCHEDULE WHERE Staff_id= :staffId AND Schedule_date >= :currentDate AND Schedule_date <= :endDate", nativeQuery = true)
    public List<WorkSchedule> getScheduleWeekForStaff(@Param("staffId") Integer staffId, @Param("currentDate") Date currentDate, @Param("endDate") Date endDate);
}
