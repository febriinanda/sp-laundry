package com.nanda.laundry.controller;

import com.nanda.laundry.model.CustomerRegistrationForm;
import com.nanda.laundry.model.StaffRegistrationForm;
import com.nanda.laundry.service.CustomerRegistrationService;
import com.nanda.laundry.service.StaffRegistrationService;
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

    @Autowired
    private StaffRegistrationService staffRegistrationService;
    @PostMapping("/customer")
    public void customerRegistration(@RequestBody CustomerRegistrationForm form){
        customerRegistrationService.register(form);
    }

    @PostMapping("/staff")
    public void staffRegistration(@RequestBody StaffRegistrationForm form){
        staffRegistrationService.register(form);
    }

}
