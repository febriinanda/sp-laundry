package com.nanda.laundry.controller;

import com.nanda.laundry.model.CustomerRegistrationForm;
import com.nanda.laundry.service.CustomerRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    @Autowired
    private CustomerRegistrationService customerRegistrationService;
    @PostMapping("/customer")
    public void customerRegistration(@RequestBody CustomerRegistrationForm form){
        customerRegistrationService.register(form);
    }

}
