package com.ms3.contactapi.api.mapper;

import com.ms3.contactapi.api.persistence.CommunicationEntity;
import com.ms3.contactapi.api.persistence.ContactEntity;
import com.ms3.contactapi.api.request.ContactParam;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class ContactParamToEntity extends CustomMapper<ContactParam, ContactEntity> {
    @Override
    public void mapAtoB(ContactParam contactParam,
                        ContactEntity contactEntity,
                        MappingContext context) {
        contactEntity.setFirstName(contactParam.getFirstName());
        contactEntity.setLastName(contactParam.getLastName());
        contactEntity.setDateOfBirth(contactParam.getDateOfBirth());
        contactEntity.setNumber(contactParam.getNumber());
        contactEntity.setGender(contactParam.getGender());
        contactEntity.setTitle(contactParam.getTitle());
        contactEntity.setType(contactParam.getType());
        contactEntity.setCity(contactParam.getCity());
        contactEntity.setStreet(contactParam.getStreet());
        contactEntity.setState(contactParam.getState());
        contactEntity.setUnit(contactParam.getUnit());
        contactEntity.setZipCode(contactParam.getZipCode());
//        contactEntity.setCommunication(mapperFacade.mapAsSet(contactParam.getCommunication(), CommunicationEntity.class));
    }
}
