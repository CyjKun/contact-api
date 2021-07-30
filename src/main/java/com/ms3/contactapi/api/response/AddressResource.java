package com.ms3.contactapi.api.response;

import lombok.Data;

@Data
public class AddressResource {
    private String type;
    private String number;
    private String street;
    private String unit;
    private String city;
    private String state;
    private String zipCode;
}
