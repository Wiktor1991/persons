package com.example.juni.customers;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CustomerRestController {
    private final CustomerService customerService;

    @GetMapping("/home")
    public String hello() {
        return "hello";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getList() {
        return ResponseEntity
                .status(200)
                .body(customerService.getList());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        customerService.deleteById(id);
    }

    @GetMapping("/add")
    public void addCustomer(Customer customer) {
        customerService.addNew(customer);
    }

    @GetMapping("/get/{id}")
    public Customer findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity modifyById(@PathVariable Integer id, @RequestBody Customer customer) {
        customerService.modify(id,customer);
        if (customerService.findById(id).getId()!=null) {
            return ResponseEntity
                    .status(200)
                    .build();
        }else{
            return ResponseEntity
                    .status(500)
                    .body("");
        }
    }
}
