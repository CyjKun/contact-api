package com.ms3.contactapi.api.model;

import lombok.Data;

@Data
public class Address {
    private String type;
    private String number;
    private String street;
    private String unit;
    private String city;
    private String state;
    private String zipCode;
}
