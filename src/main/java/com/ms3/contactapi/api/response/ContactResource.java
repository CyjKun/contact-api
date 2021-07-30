package com.ms3.contactapi.api.response;

import lombok.Data;

import java.util.Set;

@Data
public class ContactResource {
    private IdentificationResource identification;
    private AddressResource address;
    private Set<CommunicationResource> communication;
}
