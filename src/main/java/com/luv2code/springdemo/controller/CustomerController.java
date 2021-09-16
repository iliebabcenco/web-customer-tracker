package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/list")
    public String listCustomers(Model model) {

        model.addAttribute("customers", customerDao.getCustomers());

        return "list-customers";
    }

}
