package com.ms3.contactapi.api.mapper;

import com.ms3.contactapi.api.model.Contact;
import com.ms3.contactapi.api.model.Identification;
import com.ms3.contactapi.api.response.AddressResource;
import com.ms3.contactapi.api.response.CommunicationResource;
import com.ms3.contactapi.api.response.ContactResource;
import com.ms3.contactapi.api.response.IdentificationResource;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

import javax.persistence.Id;
import java.util.Date;

public class ContactToResource extends CustomMapper<Contact, ContactResource> {

    @Override
    public void mapAtoB(Contact contact,
                        ContactResource contactResource,
                        MappingContext mappingContext) {
        IdentificationResource identificationResource = new IdentificationResource();
        identificationResource.setFirstName(contact.getFirstName());
        identificationResource.setLastName(contact.getLastName());
        identificationResource.setDateOfBirth(contact.getDateOfBirth());
        identificationResource.setGender(contact.getGender());
        identificationResource.setTitle(contact.getTitle());

        AddressResource addressResource = new AddressResource();
        addressResource.setType(contact.getType());
        addressResource.setNumber(contact.getNumber());
        addressResource.setStreet(contact.getStreet());
        addressResource.setUnit(contact.getUnit());
        addressResource.setCity(contact.getCity());
        addressResource.setState(contact.getState());
        addressResource.setZipCode(contact.getZipCode());

        contactResource.setAddress(addressResource);
        contactResource.setIdentification(identificationResource);
        contactResource.setCommunication(mapperFacade.mapAsSet(contact.getCommunication(), CommunicationResource.class));
    }
}
