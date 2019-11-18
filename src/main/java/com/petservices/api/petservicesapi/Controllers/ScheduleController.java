package com.petservices.api.petservicesapi.Controllers;

import com.petservices.api.petservicesapi.Exceptions.ResourceNotFoundException;
import com.petservices.api.petservicesapi.Models.WorkSchedule;
import com.petservices.api.petservicesapi.Repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/workSchedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/all")
    public List<WorkSchedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @PostMapping("/newSchedule")
    public WorkSchedule newSchedule(WorkSchedule workSchedule, @DateTimeFormat(pattern = "yyyy-MM-dd") Date scheduleDate) {
        workSchedule.setSchedule_date(scheduleDate);
        return scheduleRepository.save(workSchedule);
    }

    @GetMapping("/getScheduleForStaff")
    public List<WorkSchedule> getScheduleForStaff(@RequestParam("staffId") Integer staffId) {

        LocalDate localDate = LocalDate.now();
        LocalDate localWeek = localDate.plusDays(7);
        Date currentDate = java.sql.Date.valueOf(localDate);
        Date endDate = java.sql.Date.valueOf(localWeek);
        List<WorkSchedule> schedules = scheduleRepository.getScheduleWeekForStaff(staffId, currentDate, endDate);
        return schedules;
    }

    @PostMapping(value = "/updateSchedule", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public WorkSchedule updateSchedule(WorkSchedule scheduleDetails, @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws ResourceNotFoundException {
        WorkSchedule workSchedule = scheduleRepository.findById(scheduleDetails.getSchedule_id()).orElseThrow(() -> new ResourceNotFoundException("Schedule not found for id: " + scheduleDetails.getSchedule_id()));

        if(date != null) {
            workSchedule.setSchedule_date(date);
        }

        if(scheduleDetails.getShift_start() != null) {
            workSchedule.setShift_start(scheduleDetails.getShift_start());
        }

        if(scheduleDetails.getShift_end() != null) {
            workSchedule.setShift_end(scheduleDetails.getShift_end());
        }

        if(scheduleDetails.getStaff_id() != null) {
            workSchedule.setStaff_id(scheduleDetails.getStaff_id());
        }

        WorkSchedule updatedSchedule = scheduleRepository.save(workSchedule);

        return updatedSchedule;
    }
}
