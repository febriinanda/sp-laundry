package com.nanda.laundry.service;

import com.nanda.laundry.entity.Person;
import com.nanda.laundry.entity.Staff;
import com.nanda.laundry.model.StaffRegistrationForm;
import com.nanda.laundry.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StaffRegistrationService {
    @Autowired
    private PersonalInformationService personalInformationService;

    @Autowired
    private StaffRepository staffRepository;

    @Transactional
    public void register(StaffRegistrationForm form){
        Person person = personalInformationService.register(form);
        Staff staff = Staff.createNew(person, form);
        staffRepository.save(staff);
    }
}
