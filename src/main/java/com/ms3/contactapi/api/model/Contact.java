package com.ms3.contactapi.api.model;

import lombok.Data;

import java.util.List;

@Data
public class Contact {
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
    private List<Communication> communication;
}
