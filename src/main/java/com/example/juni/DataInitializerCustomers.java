package com.example.juni;

import com.example.juni.customers.Customer;
import com.example.juni.customers.ICustomerRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class DataInitializerCustomers {
    private final ICustomerRepository iCustomerRepository;

    @PostConstruct
    public void add(){
        Customer customer = new Customer("Wiktor","Lulinski","lulin@gmail.com",65565);

    }
}
