package com.ms3.contactapi.api.mapper;

import com.ms3.contactapi.api.persistence.ContactEntity;
import com.ms3.contactapi.api.response.AddressResource;
import com.ms3.contactapi.api.response.CommunicationResource;
import com.ms3.contactapi.api.response.ContactResource;
import com.ms3.contactapi.api.response.IdentificationResource;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class ContactEntityToResource extends CustomMapper<ContactEntity, ContactResource> {

    @Override
    public void mapAtoB(ContactEntity contactEntity,
                        ContactResource contactResource,
                        MappingContext mappingContext) {
        IdentificationResource identificationResource = new IdentificationResource();
        identificationResource.setFirstName(contactEntity.getFirstName());
        identificationResource.setLastName(contactEntity.getLastName());
        identificationResource.setDateOfBirth(contactEntity.getDateOfBirth());
        identificationResource.setGender(contactEntity.getGender());
        identificationResource.setTitle(contactEntity.getTitle());

        AddressResource addressResource = new AddressResource();
        addressResource.setType(contactEntity.getType());
        addressResource.setNumber(contactEntity.getNumber());
        addressResource.setStreet(contactEntity.getStreet());
        addressResource.setUnit(contactEntity.getUnit());
        addressResource.setCity(contactEntity.getCity());
        addressResource.setState(contactEntity.getState());
        addressResource.setZipCode(contactEntity.getZipCode());

        contactResource.setAddress(addressResource);
        contactResource.setIdentification(identificationResource);
        contactResource.setCommunication(mapperFacade.mapAsList(contactEntity.getCommunication(), CommunicationResource.class));
    }
}
