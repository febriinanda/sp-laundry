package com.nanda.laundry;

import com.github.javafaker.Faker;
import com.nanda.laundry.entity.Person;
import com.nanda.laundry.model.CustomerRegistrationForm;
import com.nanda.laundry.model.StaffRegistrationForm;
import com.nanda.laundry.service.CustomerRegistrationService;
import com.nanda.laundry.service.StaffRegistrationService;
import com.nanda.laundry.utility.faker.FakerService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LaundryApplication {
	@Autowired
	private FakerService fakerService;

	@Autowired
	private CustomerRegistrationService customerRegistrationService;

	@Autowired
	private StaffRegistrationService staffRegistrationService;

	public static void main(String[] args) {
		SpringApplication.run(LaundryApplication.class, args);
	}

	@PostConstruct
	private void customerSample(){
		Faker faker = new Faker();
		int customerSample = faker.number().numberBetween(1, 7);
		for (int i = 0; i < customerSample; i++) {
			Person person = new Person(faker);
			CustomerRegistrationForm form = new CustomerRegistrationForm();
			form.setName(person.getName());
			form.setAddress(person.getAddress());
			form.setBirthDate(person.getBirthDate());
			form.setGender(person.getGender());
			form.setMobilePhone(person.getMobilePhone());
			customerRegistrationService.register(form);
		}
		log.info("Customer sample +"+customerSample);
	}

	@PostConstruct
	private void staffSample(){
		Faker faker = new Faker();
		int staffSample = faker.number().numberBetween(0, 2);
		for (int i = 0; i < staffSample ; i++) {
			Person person = new Person(faker);
			StaffRegistrationForm form = new StaffRegistrationForm();
			form.setName(person.getName());
			form.setAddress(person.getAddress());
			form.setBirthDate(person.getBirthDate());
			form.setGender(person.getGender());
			form.setMobilePhone(person.getMobilePhone());
			form.setCitizenshipId(faker.number().digits(16));
			staffRegistrationService.register(form);
		}

		log.info("Staff sample +"+staffSample);
	}
}
