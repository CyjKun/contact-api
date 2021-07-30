package com.ms3.contactapi.api.request;

import lombok.Data;

import java.util.Date;

@Data
public class IdentificationParam {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String title;
}
