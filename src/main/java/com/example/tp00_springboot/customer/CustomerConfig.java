package com.example.tp00_springboot.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;

@Configuration
public class CustomerConfig {

    private final CustomerRepository customerRepository;

    public CustomerConfig(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Bean
    CommandLineRunner init_customer(){
        return args -> {
            customerRepository.save(new Customer(null,"chebihi","chebihi@mail.com"));
            customerRepository.save(new Customer(null,"ahmed","ahmed@mail.com"));
            customerRepository.save(new Customer(null,"sanaa","sanaa@mail.com"));
            customerRepository.save(new Customer(null,"chebihi","chebihi@mail.com"));
            customerRepository.save(new Customer(null,"chebihi","chebihi@mail.com"));


            customerRepository.findAll(PageRequest.of(0,3))
                    .forEach(System.out::println);

        };
    }
}
