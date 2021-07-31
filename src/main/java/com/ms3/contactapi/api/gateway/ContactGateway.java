package com.ms3.contactapi.api.gateway;

import com.ms3.contactapi.api.model.Contact;
import com.ms3.contactapi.api.persistence.ContactEntity;

import java.util.List;

public interface ContactGateway {

    Contact create(Contact contact);

    List<ContactEntity> getAll();

    ContactEntity getOneById(Long id);

    void deletedById(Long id);
}
