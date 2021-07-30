package com.ms3.contactapi.api.interactor;

import com.ms3.contactapi.api.model.Contact;
import com.ms3.contactapi.api.request.ContactParam;

public interface CreateContact {
    Contact execute(ContactParam param);
}
