package com.example.demo.controller;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/customers")
    public String list(Model model) {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customers/customerList";
    }

    /**
     * 회원가입 전 동의 화면에 필요한 정보를 내려주는 엔드포인트
     * @param request
     * @return
     */
    @PostMapping(value = "/join")
    public String join(@RequestBody JoinRequest request) {
        Customer entity = new Customer(request.firstName, request.lastName);

        customerRepository.save(entity);

        return "회원가입 성공";
    }

    static class JoinRequest {

        private String firstName;
        private String lastName;

        public JoinRequest() {
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }
}
