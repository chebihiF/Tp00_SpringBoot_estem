package com.example.tp00_springboot.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "service1")
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) throws Exception {
        //process metier
        if(!customer.getName().startsWith("A"))
            throw new RuntimeException("customer name must start with a 'A'");
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws Exception {
        if(!customer.getName().startsWith("A"))
            throw new RuntimeException("customer name must start with a 'A'");
        return customerRepository.save(customer);
    }

    @Override
    public Customer deleteCustomer(Long id) throws Exception {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
        return customer;
    }

    @Override
    public Customer getCustomerById(Long id) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent())
            return customerOptional.get();
        throw new RuntimeException("customer with id "+id+" not found");
    }

    @Override
    public List<Customer> getCustomers() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> getCustomersByPage(int page, int size) throws Exception {
        return customerRepository.findAll(PageRequest.of(page,size));
    }
}
