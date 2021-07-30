package com.ms3.contactapi.api.controller;

import com.ms3.contactapi.api.request.ContactForm;
import com.ms3.contactapi.api.response.ContactResource;
import com.ms3.contactapi.api.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContactApiController {

    private final ContactService contactService;

    @PostMapping({
            "v1/create"
    })
    public ContactResource createContact(@RequestBody ContactForm contactForm) {
        return contactService.createContact(contactForm);
    }
}
