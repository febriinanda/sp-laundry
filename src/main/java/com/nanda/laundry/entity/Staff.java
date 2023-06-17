package com.nanda.laundry.entity;

import com.nanda.laundry.model.StaffRegistrationForm;
import com.nanda.laundry.utility.RegistrationNumberGenerator;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "m_staff")
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String registrationNumber;
    private Date joinDate;
    private String citizenshipId;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Staff(Person person) {
        this.person = person;
    }

    public static Staff createNew(Person person, StaffRegistrationForm form){
        Staff staff = new Staff(person);
        staff.setJoinDate(new Date());
        staff.setCitizenshipId(form.getCitizenshipId());
        staff.generateRegistrationNumber();
        return staff;
    }

    private void generateRegistrationNumber() {
        this.registrationNumber = "#STFF-"+ RegistrationNumberGenerator.generate(this.joinDate);
    }
}
