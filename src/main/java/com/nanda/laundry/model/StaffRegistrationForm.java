package com.nanda.laundry.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StaffRegistrationForm implements PersonalInformationForm{
    private String name;
    private Date birthDate;
    private String address;
    private String gender;
    private String mobilePhone;
    private String citizenshipId;
}
