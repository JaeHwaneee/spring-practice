package com.example.demo.controller;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JaeHwanController {

    CustomerRepository customerRepository;

    public JaeHwanController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/jaehwan")
    public String list(Model model) {
        Customer customer = customerRepository.findById(5);
        model.addAttribute("customers", customer);
        return "jaehwan/info";
    }
}
