package com.ms3.contactapi.api.controller;

import com.ms3.contactapi.api.request.ContactForm;
import com.ms3.contactapi.api.response.ContactResource;
import com.ms3.contactapi.api.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContactApiController {

    private final ContactService contactService;

    @PostMapping({"create"})
    public ContactResource createContact(@RequestBody ContactForm contactForm) {
        return contactService.createContact(contactForm);
    }

    @GetMapping
    public List<ContactResource>  getAllContacts() {
        return contactService.getAllContacts();
    }
}
