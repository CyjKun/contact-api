package com.ms3.contactapi.api.gateway;

import com.ms3.contactapi.api.model.Contact;

public interface ContactGateway {

    Contact create(Contact contact);
}
