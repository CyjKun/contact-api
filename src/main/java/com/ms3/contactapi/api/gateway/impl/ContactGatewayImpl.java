package com.ms3.contactapi.api.gateway.impl;

import com.ms3.contactapi.api.gateway.ContactGateway;
import com.ms3.contactapi.api.mapper.ContactMapper;
import com.ms3.contactapi.api.model.Contact;
import com.ms3.contactapi.api.persistence.ContactEntity;
import com.ms3.contactapi.api.persistence.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactGatewayImpl implements ContactGateway {

    private final ContactMapper mapper;
    private final ContactRepository repository;

    @Override
    public Contact create(Contact contact){
        ContactEntity contactEntity = mapper.map(contact, ContactEntity.class);

        contactEntity = repository.save(contactEntity);
        return null;
    }
}
