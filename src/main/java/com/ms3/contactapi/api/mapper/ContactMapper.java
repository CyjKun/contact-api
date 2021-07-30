package com.ms3.contactapi.api.mapper;

import com.ms3.contactapi.api.model.Communication;
import com.ms3.contactapi.api.model.Contact;
import com.ms3.contactapi.api.persistence.CommunicationEntity;
import com.ms3.contactapi.api.persistence.ContactEntity;
import com.ms3.contactapi.api.request.CommunicationForm;
import com.ms3.contactapi.api.request.CommunicationParam;
import com.ms3.contactapi.api.request.ContactForm;
import com.ms3.contactapi.api.request.ContactParam;
import com.ms3.contactapi.api.response.CommunicationResource;
import com.ms3.contactapi.api.response.ContactResource;
import com.ms3.contactapi.common.annotation.BeanMapper;
import com.ms3.contactapi.common.mapper.ServiceMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@BeanMapper
@Component
public class ContactMapper extends ServiceMapper {

    @Override
    protected void configure(MapperFactory mapperFactory) {
        super.configure(mapperFactory);
        this.addAllSpringBeans(super.getApplicationContext());

        mapperFactory.classMap(ContactParam.class, ContactEntity.class)
                .customize(new ContactParamToEntity())
                .register();

        mapperFactory.classMap(CommunicationParam.class, CommunicationEntity.class)
                .byDefault()
                .register();

        mapperFactory.classMap(Contact.class, ContactResource.class)
                .customize(new ContactToResource())
                .register();

        mapperFactory.classMap(Communication.class, CommunicationResource.class)
                .byDefault()
                .register();
    }
}
