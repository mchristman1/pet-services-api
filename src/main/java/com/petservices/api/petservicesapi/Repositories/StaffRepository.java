package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    @Query(value = "SELECT * FROM STAFF WHERE Department_id = :deptId", nativeQuery = true)
    List<Staff> findByDept(@Param("deptId") Integer deptId);

    @Query(value = "SELECT * FROM STAFF WHERE Email= :email", nativeQuery = true)
    List<Staff> findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM STAFF WHERE Phone_number= :phone_number", nativeQuery = true)
    List<Staff> findByPhone(@Param("phone_number") BigInteger phone_number);
}
