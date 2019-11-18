package com.petservices.api.petservicesapi.Controllers;

import com.petservices.api.petservicesapi.Exceptions.ResourceNotFoundException;
import com.petservices.api.petservicesapi.Models.Customer;
import com.petservices.api.petservicesapi.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
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

    @GetMapping(value = "/getCustomerId", produces = MediaType.TEXT_HTML_VALUE)
    public String getCustomerId(@RequestParam(value = "email") String email) {
        List<Customer> customers = customerRepository.findByEmail(email);

        if (customers.isEmpty()) {
            return "-1";
        } else {
            return Integer.toString(customers.get(0).getCustomer_id());
        }
    }

    @GetMapping("/getCustomerByEmail")
    public List<Customer> getCustomerByEmail(@RequestParam(value = "email") String email) {
        System.out.println("\n\n----- GET CUSTOMER BY EMAIL -----");
        List<Customer> customers = customerRepository.findByEmail(email);

        return customers;
    }

    @GetMapping("/getCustomerByPhone")
    public List<Customer> getCustomerByPhone(@RequestParam(value = "phone_Number") BigInteger phoneNumber) {

        List<Customer> customers = customerRepository.findByPhone(phoneNumber);

        return customers;
    }

    @PostMapping(value = "/newCustomer", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Customer newCustomer(Customer customer) {
        System.out.println("\n\n\n--------- " + customer.toString() + " -----------\n\n\n");
        return customerRepository.save(customer);
    }

    @PostMapping(value = "/updateCustomer", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestParam(value = "id") Integer customerId, Customer customerDetails) throws ResourceNotFoundException {
        System.out.println("\n\n--- PUT CUSTOMER ---\n\n");
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found for id :: " + customerId));

        if(customerDetails.getFname() != null) {
            customer.setFname(customerDetails.getFname());
        }

        if(customerDetails.getLname() != null) {
            customer.setLname(customerDetails.getLname());
        }

        if(customerDetails.getPhone_Number() != null) {
            customer.setPhone_Number(customerDetails.getPhone_Number());
        }

        if(customerDetails.getEmail() != null) {
            customer.setEmail(customerDetails.getEmail());
        }

        Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }


    @PostMapping("/deleteCustomer")
    public Map<String, Boolean> deleteCustomer(@RequestParam(value = "id") Integer customerId) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found for id: " + customerId));
        customerRepository.delete(customer);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
