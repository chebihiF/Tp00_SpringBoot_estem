package com.example.tp00_springboot.customer;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getAll() {
        try {
            return customerService.getCustomers();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Customer>();
        }
    }

    @PostMapping
    Customer saveCustomer(@RequestBody Customer customer){
        try {
            return customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return null ;
        }
    }
}
