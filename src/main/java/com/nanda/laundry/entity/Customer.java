package com.nanda.laundry.entity;

import com.nanda.laundry.utility.RegistrationNumberGenerator;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
        this.registrationNumber = "#CUST-" + RegistrationNumberGenerator.generate(this.getJoinDate());
    }
}
