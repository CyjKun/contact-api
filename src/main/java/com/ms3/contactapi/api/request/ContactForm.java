package com.ms3.contactapi.api.request;

import lombok.Data;

import java.util.Set;

@Data
public class ContactForm {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String title;
    private String type;
    private String number;
    private String street;
    private String unit;
    private String city;
    private String state;
    private String zipCode;
    private Set<CommunicationForm> communication;

}
