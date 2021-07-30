package com.ms3.contactapi.api.service.impl;

import com.ms3.contactapi.api.interactor.CreateContact;
import com.ms3.contactapi.api.mapper.ContactMapper;
import com.ms3.contactapi.api.model.Address;
import com.ms3.contactapi.api.model.Contact;
import com.ms3.contactapi.api.model.Identification;
import com.ms3.contactapi.api.request.ContactForm;
import com.ms3.contactapi.api.request.ContactParam;
import com.ms3.contactapi.api.response.ContactResource;
import com.ms3.contactapi.api.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final CreateContact createContact;
    private final ContactMapper mapper;

    @Override
    public ContactResource createContact(ContactForm contactForm) {
        ContactParam param = mapper.map(contactForm, ContactParam.class);

        Contact contact = createContact.execute(param);

        return mapper.map(contact, ContactResource.class);
    }
}
