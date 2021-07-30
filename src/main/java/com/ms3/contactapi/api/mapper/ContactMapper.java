package com.ms3.contactapi.api.mapper;

import com.ms3.contactapi.api.model.Communication;
import com.ms3.contactapi.api.model.Contact;
import com.ms3.contactapi.api.persistence.CommunicationEntity;
import com.ms3.contactapi.api.persistence.ContactEntity;
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

        mapperFactory.classMap(ContactEntity.class, ContactResource.class)
                .customize(new ContactEntityToResource())
                .register();

        mapperFactory.classMap(Contact.class, ContactResource.class)
                .customize(new ContactToResource())
                .register();
    }
}
