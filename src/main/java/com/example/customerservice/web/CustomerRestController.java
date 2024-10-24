package com.example.customerservice.web;

import com.example.customerservice.dao.entities.Customer;
import com.example.customerservice.dao.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){
        Customer c = new Customer();
        c.setName(customer.getName());
        c.setEmail(customer.getEmail());
        customerRepository.save(c);
        return c;
    }
    @GetMapping("/{id}")
    public  Customer customerById(@PathVariable Long id) throws Exception{
        return customerRepository.findById(id).orElseThrow(() -> new Exception("customer introuvable"));
    }


}
