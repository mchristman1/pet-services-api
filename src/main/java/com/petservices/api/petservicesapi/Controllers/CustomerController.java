package com.petservices.api.petservicesapi.Controllers;

import com.petservices.api.petservicesapi.Exceptions.ResourceNotFoundException;
import com.petservices.api.petservicesapi.Models.Customer;
import com.petservices.api.petservicesapi.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/getCustomerById")
    public ResponseEntity<Customer> getCustomerById(@RequestParam(value = "id") Integer customerId) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found for id :: " + customerId));
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/getCustomerByEmail")
    public List<Customer> getCustomerByEmail(@RequestParam(value = "email") String email) {

        List<Customer> customers = customerRepository.findByEmail(email);

        return customers;
    }

    @PostMapping(value = "/newCustomer", consumes = "application/json")
    public Customer newCustomer(@Valid @RequestBody @DateTimeFormat(pattern = "yyyy-mm-dd") Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping("/deleteCustomer")
    public Map<String, Boolean> deleteCustomer(@RequestParam(value = "id") Integer customerId) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found for id: " + customerId));
        customerRepository.delete(customer);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
