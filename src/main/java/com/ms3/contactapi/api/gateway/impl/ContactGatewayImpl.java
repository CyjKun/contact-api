package com.ms3.contactapi.api.gateway.impl;

import com.ms3.contactapi.api.gateway.ContactGateway;
import com.ms3.contactapi.api.mapper.ContactMapper;
import com.ms3.contactapi.api.model.Contact;
import com.ms3.contactapi.api.persistence.CommunicationEntity;
import com.ms3.contactapi.api.persistence.ContactEntity;
import com.ms3.contactapi.api.persistence.repository.CommunicationRepository;
import com.ms3.contactapi.api.persistence.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactGatewayImpl implements ContactGateway {

    private final ContactMapper mapper;
    private final ContactRepository contactRepository;
    private final CommunicationRepository communicationRepository;

    @Override
    public Contact create(Contact contact){
        ContactEntity contactEntity = mapper.map(contact, ContactEntity.class);
        contactRepository.saveAndFlush(contactEntity);
        saveCommunication(contact, contactEntity);
        return mapper.map(contactEntity, Contact.class);
    }

    @Override
    public List<ContactEntity> getAll() {
        return contactRepository.findAll();
    }

    private void saveCommunication(Contact contact, ContactEntity contactEntity){
        List<CommunicationEntity> communicationEntity = mapper.mapAsList(contact.getCommunication(), CommunicationEntity.class);
        communicationEntity.forEach(entity -> {
            entity.setContact(contactEntity);
        });
        communicationRepository.saveAllAndFlush(communicationEntity);

    }
}
