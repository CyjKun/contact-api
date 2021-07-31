package com.ms3.contactapi.api.controller;

import com.ms3.contactapi.api.request.ContactForm;
import com.ms3.contactapi.api.response.ContactResource;
import com.ms3.contactapi.api.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContactApiController {

    private final ContactService contactService;

    @PostMapping("/create")
    public ContactResource createContact(@RequestBody ContactForm contactForm) {
        return contactService.createContact(contactForm);
    }

    @GetMapping
    public List<ContactResource>  getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ContactResource getContact(@PathVariable Long id) {
        return contactService.getContact(id);
    }

    @PutMapping("/update/{id}")
    public ContactResource updateContact(@PathVariable Long id,
                                         @RequestBody ContactForm contactForm) {
        return contactService.updateContact(id, contactForm);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}
