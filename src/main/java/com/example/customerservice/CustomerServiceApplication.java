package com.example.customerservice;

import com.example.customerservice.dao.entities.Customer;
import com.example.customerservice.dao.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.customerservice.dao.repositories")
@EntityScan(basePackages = "com.example.customerservice.dao..entities")
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("x").email("x@email.com").build());
            customerRepository.save(Customer.builder().name("y").email("y@email.com").build());
        };
    }

}
