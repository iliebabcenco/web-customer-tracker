package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(@RequestParam(value = "sortKey", required = false) String sortKey,
                                Model model) {
        List<Customer> customers;
        if (sortKey == null) {
            customers = customerService.getCustomers();
        } else {
            customers = customerService.getSortedCustomers(sortKey);
        }
        System.out.println("\n\n\n"+customers+"\n\n\n");
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/add")
    public String showFormForAdd(Model model) {

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/add")
    public String addNewCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("customerId") int id, Model model) {

        Customer customer = customerService.getCustomer(id);

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id) {

        customerService.deleteCustomer(id);


        return "redirect:/customers/list";
    }

    @GetMapping("/search")
    public String searchForCustomers(@RequestParam("searchKeyword") String keyword,
                                     Model model) {
        List<Customer> customers = customerService.searchCustomers(keyword);
        model.addAttribute("customers", customers);
        return "list-customers";
    }

}
