package com.petservices.api.petservicesapi.Controllers;

import com.petservices.api.petservicesapi.Exceptions.ResourceNotFoundException;
import com.petservices.api.petservicesapi.Models.Staff;
import com.petservices.api.petservicesapi.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/all")
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @GetMapping("/getStaffById")
    public ResponseEntity<Staff> getStaffById(@RequestParam("id") Integer staffId) throws ResourceNotFoundException {
        Staff staff = staffRepository.findById(staffId).orElseThrow(() -> new ResourceNotFoundException("Staff Member Not Found for id: " + staffId));

        return ResponseEntity.ok(staff);
    }

    @GetMapping("/getStaffByDept")
    public List<Staff> getStaffByDept(@RequestParam("deptId") Integer departmentId) {
        return staffRepository.findByDept(departmentId);
    }

    @GetMapping("/getStaffByEmail")
    public List<Staff> getCustomerByEmail(@RequestParam(value = "email") String email) {

        List<Staff> staff = staffRepository.findByEmail(email);

        return staff;
    }

    @GetMapping("/getStaffByPhone")
    public List<Staff> getCustomerByPhone(@RequestParam(value = "phone_number") BigInteger phoneNumber) {

        List<Staff> staff = staffRepository.findByPhone(phoneNumber);

        return staff;
    }

    @PostMapping(value = "/newStaff", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Staff> newStaff(Staff staff) {
        return ResponseEntity.ok(staffRepository.save(staff));
    }

    @GetMapping(value = "/getStaffId", produces = MediaType.TEXT_HTML_VALUE)
    public String getStaffId(@RequestParam(value = "email") String email) {
        List<Staff> staff = staffRepository.findByEmail(email);

        if (staff.isEmpty()) {
            return "-1";
        } else {
            return Integer.toString(staff.get(0).getStaff_id());
        }
    }

    @PostMapping(value = "/updateStaff", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Staff> updateStaff(@RequestParam("id") Integer staffId, Staff staffDetails) throws ResourceNotFoundException {
        Staff staff = staffRepository.findById(staffId).orElseThrow(() -> new ResourceNotFoundException("Staff Member not found for id: " + staffId));

        if(staffDetails.getAddress() != null) {
            staff.setAddress(staffDetails.getAddress());
        }

        if(staffDetails.getFname() != null) {
            staff.setFname(staffDetails.getFname());
        }

        if(staffDetails.getLname() != null) {
            staff.setLname(staffDetails.getLname());
        }

        if(staffDetails.getDepartment_id() != null) {
            staff.setDepartment_id(staffDetails.getDepartment_id());
        }

        if(staffDetails.getJob_title() != null) {
            staff.setJob_title(staffDetails.getJob_title());
        }

        if(staffDetails.getEmail() != null) {
            staff.setEmail(staffDetails.getEmail());
        }

        if(staffDetails.getPhone_number() != null) {
            staff.setPhone_number(staffDetails.getPhone_number());
        }

        Staff updatedStaff = staffRepository.save(staff);

        return ResponseEntity.ok(updatedStaff);
    }

    @PostMapping("/deleteStaff")
    public ResponseEntity<String> deleteStaff(@RequestParam("id") Integer id) throws ResourceNotFoundException {
        Staff staff = staffRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Staff member not found for id: " + id));
        staffRepository.delete(staff);

        return ResponseEntity.ok("deleted");
    }

}
