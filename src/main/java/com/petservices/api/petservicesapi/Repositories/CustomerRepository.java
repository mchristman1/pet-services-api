package com.petservices.api.petservicesapi.Repositories;

import com.petservices.api.petservicesapi.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM CUSTOMER WHERE Email= :email", nativeQuery = true)
    List<Customer> findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM CUSTOMER WHERE Phone_Number= :phone_number", nativeQuery = true)
    List<Customer> findByPhone(@Param("phone_number")BigInteger phone_number);
}
