package com.ms3.contactapi.api.service;

import com.ms3.contactapi.api.request.ContactForm;
import com.ms3.contactapi.api.response.ContactResource;
import com.ms3.contactapi.common.model.PaginatedItem;

public interface ContactService {
    ContactResource createContact(ContactForm contactForm);

    PaginatedItem<? extends ContactResource> getAllContacts();

    ContactResource getContact(Long id);

    ContactResource updateContact(Long id, ContactForm contactForm);

    void deleteContact(Long id);
}
