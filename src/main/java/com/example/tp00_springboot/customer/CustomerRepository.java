package com.example.tp00_springboot.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @GetMapping("/customersByEmail/{email}")
    public List<Customer> findCustomerByEmailContains(@PathVariable(name="email") String email);

    @Query(value = "from Customer c where c.name like :name and c.email like :email and c.name = 'test'")
    public List<Customer> getMyCustomers(String name, String email);
}
