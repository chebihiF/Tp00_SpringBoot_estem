package com.example.tp00_springboot.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerFrontController {

    private final ICustomerService customerService;

    public CustomerFrontController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/hello")
    public String index(Model model){

        try {
            model.addAttribute("customers",customerService.getCustomers());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error",e.getMessage());
        }

        return "customers";
    }
}
