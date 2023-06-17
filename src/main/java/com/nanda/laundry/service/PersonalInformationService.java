package com.nanda.laundry.service;

import com.nanda.laundry.entity.Person;
import com.nanda.laundry.model.PersonalInformationForm;
import com.nanda.laundry.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PersonalInformationService {
    @Autowired
    private PersonRepository personRepository;

    public Person register(PersonalInformationForm form){
        String mobilePhone = form.getMobilePhone();
        personRepository.findFirstByMobilePhone(mobilePhone).ifPresent(o->{
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This number is registered");
        });

        Person person = new Person(form);
        return personRepository.save(person);
    }
}
