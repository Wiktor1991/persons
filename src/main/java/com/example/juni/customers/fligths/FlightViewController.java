package com.example.juni.customers.fligths;

import com.example.juni.customers.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlightViewController {
    @GetMapping("/nowy")
    public String nowa(Model model){
        model.addAttribute("now", new Customer());
        return "nowy";
    }
}
