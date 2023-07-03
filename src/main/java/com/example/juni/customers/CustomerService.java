package com.example.juni.customers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    public List<Customer>getList() {
       return customerRepository.getList();
    }

    public void deleteById(Integer id) {
        customerRepository.delete(id);
    }

    public void addNew(Customer customer) {
        customerRepository.addNew(customer);
    }

    public Customer findById(Integer id) {
        return Optional.ofNullable(customerRepository.findById(id))
                .orElseThrow(() -> new RuntimeException("Nie ma takiego uzytkownika")).orElse(null);
    }

    public void modify(Integer id, Customer customer) {
        customerRepository.modify(id,customer);
    }
}
