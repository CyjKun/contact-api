package com.ms3.contactapi.api.service;

import com.ms3.contactapi.api.request.ContactForm;
import com.ms3.contactapi.api.response.ContactResource;

import java.util.List;

public interface ContactService {
    ContactResource createContact(ContactForm contactForm);

    List<ContactResource> getAllContacts();

    ContactResource getContact(Long id);

    ContactResource updateContact(Long id, ContactForm contactForm);
}
