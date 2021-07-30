package com.ms3.contactapi.api.interactor.impl;

import com.ms3.contactapi.api.gateway.ContactGateway;
import com.ms3.contactapi.api.interactor.CreateContact;
import com.ms3.contactapi.api.mapper.ContactMapper;
import com.ms3.contactapi.api.model.Contact;
import com.ms3.contactapi.api.request.ContactParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateContactImpl implements CreateContact {

    private final ContactMapper contactMapper;
    private final ContactGateway contactGateway;

    @Override
    public Contact execute(ContactParam param) {
        Contact contact = contactMapper.map(param, Contact.class);
        return contactGateway.create(contact);
    }
}
