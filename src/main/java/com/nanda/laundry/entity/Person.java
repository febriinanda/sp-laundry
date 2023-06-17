package com.nanda.laundry.entity;

import com.github.javafaker.Faker;
import com.nanda.laundry.model.PersonalInformationForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "m_person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Date birthDate;
    private String address;
    private String gender;

    @Column(unique = true)
    private String mobilePhone;

    public Person(PersonalInformationForm form) {
        this.name = form.getName();
        this.birthDate = form.getBirthDate();
        this.address = form.getAddress();
        this.gender = form.getGender();
        this.mobilePhone = form.getMobilePhone();
    }

    public Person(Faker faker) {
        this.name = faker.name().fullName();
        this.birthDate = faker.date().birthday(15,70);
        this.address = faker.address().fullAddress();
        this.gender = faker.demographic().sex();
        this.mobilePhone = faker.phoneNumber().cellPhone();
    }
}
