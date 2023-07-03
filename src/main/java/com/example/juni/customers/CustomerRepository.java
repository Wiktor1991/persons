package com.example.juni.customers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {
    private final ICustomerRepository iCustomerRepository;
    public List<Customer>getList() {
        return iCustomerRepository.findAll();
    }

    public void delete(Integer id) {
        iCustomerRepository.deleteById(id);
    }

    public void addNew(Customer customer) {
        iCustomerRepository.save(customer);
    }

    public Optional<Customer> findById(Integer id) {
      return iCustomerRepository.findById(id);
    }

    public void modify(Integer id, Customer customer) {
        iCustomerRepository.modify(id, customer.firstName, customer.lastName, customer.email, String.valueOf(customer.phone));

    }
    public void modifyFromTemplate(Integer id,String firstName, String lastName, String email, String phone){
        iCustomerRepository.modify(id,firstName,lastName,email,phone);
    }

    public void mod1(Integer id, String name){
        iCustomerRepository.update(id,name);
    }
}
