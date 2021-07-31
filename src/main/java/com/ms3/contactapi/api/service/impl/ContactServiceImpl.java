package com.ms3.contactapi.api.service.impl;

import com.ms3.contactapi.api.gateway.ContactGateway;
import com.ms3.contactapi.api.interactor.CreateContact;
import com.ms3.contactapi.api.interactor.UpdateContact;
import com.ms3.contactapi.api.mapper.ContactMapper;
import com.ms3.contactapi.api.model.Contact;
import com.ms3.contactapi.api.persistence.ContactEntity;
import com.ms3.contactapi.api.request.ContactForm;
import com.ms3.contactapi.api.request.ContactParam;
import com.ms3.contactapi.api.response.ContactResource;
import com.ms3.contactapi.api.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final CreateContact createContact;
    private final UpdateContact updateContact;
    private final ContactGateway contactGateway;
    private final ContactMapper mapper;

    @Override
    public ContactResource createContact(ContactForm contactForm) {
        ContactParam param = mapper.map(contactForm, ContactParam.class);

        Contact contact = createContact.execute(param);

        return mapper.map(contact, ContactResource.class);
    }

    @Override
    public List<ContactResource> getAllContacts() {
        List<ContactEntity> contactEntities = contactGateway.getAll();
        return mapper.mapAsList(contactEntities, ContactResource.class);
    }

    @Override
    public ContactResource getContact(Long id) {
        return mapper.map(contactGateway.getOneById(id), ContactResource.class);
    }

    @Override
    public ContactResource updateContact(Long id,
                                         ContactForm contactForm) {
        ContactParam contactParam = mapper.map(contactForm, ContactParam.class);
        Contact contact = updateContact.execute(id, contactParam);

        return mapper.map(contact, ContactResource.class);
    }

    @Override
    public void deleteContact(Long id) {
        contactGateway.deletedById(id);
    }
}
