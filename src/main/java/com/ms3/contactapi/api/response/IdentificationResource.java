package com.ms3.contactapi.api.response;

import lombok.Data;

import java.util.Date;

@Data
public class IdentificationResource {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String title;

}
