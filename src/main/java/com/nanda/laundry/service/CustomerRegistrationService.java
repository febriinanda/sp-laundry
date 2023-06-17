package com.nanda.laundry.service;

import com.nanda.laundry.entity.Customer;
import com.nanda.laundry.entity.Person;
import com.nanda.laundry.model.CustomerRegistrationForm;
import com.nanda.laundry.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class CustomerRegistrationService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PersonalInformationService personalInformationService;

    @Transactional
    public void register(CustomerRegistrationForm form){
        Person person = personalInformationService.register(form);
        Customer customer = Customer.createNew(person);
        customerRepository.save(customer);
    }
}
