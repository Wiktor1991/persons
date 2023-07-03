package com.example.juni.customers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CustomerViewController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private Object modifyCustomer;

    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("lista",customerService.getList());
        model.addAttribute("newCustomer",new Customer());
        model.addAttribute("cust",new Customer());
        model.addAttribute("uzyt",new Customer());
        model.addAttribute("obiekt", new Customer());
        return "index";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute("cust") Customer customer){
        log.info(customer.getId().toString());
        customerService.deleteById(customer.getId());
        return "redirect:/show";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("cust")Customer customer){
        log.info(customer.toString());
        if (!customer.firstName.isEmpty() && !customer.lastName.isEmpty()){
        customerService.addNew(customer);
        } else{
            throw new RuntimeException("Niema wyniku");
        }
        return "redirect:/show";
    }

    @PostMapping("/szczegoly")
    public String details(@ModelAttribute("cust")Customer customer, RedirectAttributes re){
        re.addFlashAttribute("savedCustomer",customerService.findById(customer.getId()));
        return "redirect:/nowa";
    }
    @GetMapping("/nowa")
    public String detailsPage(){
        return "details";
    }
   @PostMapping("/update")
    public String updateRecord(@ModelAttribute("obiekt") Customer customer, RedirectAttributes re){
        re.addFlashAttribute("modifyCustomer",customerService.findById(customer.getId()));
       System.out.println(customerService.findById(customer.getId()));
       return "redirect:/form";

   }

   @GetMapping("/form")
    public String upPage(@ModelAttribute("modifyCustomer")Customer customer, Model model){
       Customer customer2 = new Customer(customer.getId(),customer.getFirstName(),customer.getLastName(),customer.getEmail(), customer.getPhone());
       model.addAttribute("cust", customer2 );
       return "modify";
   }

   @PostMapping("/put")
    public String updateCustomer(@ModelAttribute("cust") Customer customer){
       log.info(customer.getFirstName());
       customerRepository.modifyFromTemplate(customer.id, customer.getFirstName(),customer.lastName,customer.getEmail(), String.valueOf(customer.phone));

       return "redirect:/show";
   }
}
