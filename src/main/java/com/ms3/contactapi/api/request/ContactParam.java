package com.ms3.contactapi.api.request;

import com.ms3.contactapi.api.model.Address;
import com.ms3.contactapi.api.model.Communication;
import com.ms3.contactapi.api.model.Identification;
import lombok.Data;

import java.util.Set;

@Data
public class ContactParam {
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
    private Set<CommunicationParam> communication;
}
