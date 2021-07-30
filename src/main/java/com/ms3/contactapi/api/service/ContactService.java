package com.ms3.contactapi.api.service;

import com.ms3.contactapi.api.request.ContactForm;
import com.ms3.contactapi.api.response.ContactResource;

public interface ContactService {
    ContactResource createContact(ContactForm contactForm);
}
