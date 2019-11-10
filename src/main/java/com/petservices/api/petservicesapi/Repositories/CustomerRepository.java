package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM CUSTOMER WHERE Email= :email", nativeQuery = true)
    List<Customer> findByEmail(@Param("email") String email);
}
