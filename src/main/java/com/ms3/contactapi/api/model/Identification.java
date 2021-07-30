package com.ms3.contactapi.api.model;

import lombok.Data;

import java.util.Date;

@Data
public class Identification {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String title;
}
