package com.nanda.laundry.service;

import com.nanda.laundry.entity.Customer;
import com.nanda.laundry.entity.Person;
import com.nanda.laundry.model.CustomerRegistrationForm;
import com.nanda.laundry.repository.CustomerRepository;
import com.nanda.laundry.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerRegistrationService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void register(CustomerRegistrationForm form){
        String mobilePhone = form.getMobilePhone();
        personRepository.findFirstByMobilePhone(mobilePhone).orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "This number is registered"));

        Person person = new Person(form);
        personRepository.save(person);

        Customer customer = Customer.createNew(person);
        customerRepository.save(customer);
    }
}
