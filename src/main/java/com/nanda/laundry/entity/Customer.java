package com.nanda.laundry.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "m_customer")
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String registrationNumber;
    private Date joinDate;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Customer(Person person) {
        this.person = person;
    }

    public static Customer createNew(Person person) {
        Customer customer = new Customer(person);
        customer.setJoinDate(new Date());
        customer.generateRegistrationNumber();

        return customer;
    }

    private void generateRegistrationNumber() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.getJoinDate());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        Random random = new Random();
        int rnd = random.nextInt(999999);

        this.registrationNumber = "#CUST-" + String.format("%04d", year) + '.' + String.format("%02d", month) + '.' + String.format("%06d", rnd);
    }
}
