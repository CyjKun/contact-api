package com.ms3.contactapi.api.interactor.impl;

import com.ms3.contactapi.api.interactor.UpdateContact;
import com.ms3.contactapi.api.mapper.ContactMapper;
import com.ms3.contactapi.api.model.Contact;
import com.ms3.contactapi.api.persistence.CommunicationEntity;
import com.ms3.contactapi.api.persistence.ContactEntity;
import com.ms3.contactapi.api.persistence.repository.CommunicationRepository;
import com.ms3.contactapi.api.persistence.repository.ContactRepository;
import com.ms3.contactapi.api.request.ContactParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateContactImpl implements UpdateContact {

    private final ContactRepository contactRepository;
    private final CommunicationRepository communicationRepository;
    private final ContactMapper mapper;

    @Override
    public Contact execute(Long id,
                           ContactParam contactParam) {
        ContactEntity entity = contactRepository.getById(id);
        entity.setFirstName(contactParam.getFirstName());
        entity.setLastName(contactParam.getLastName());
        entity.setDateOfBirth(contactParam.getDateOfBirth());
        entity.setNumber(contactParam.getNumber());
        entity.setGender(contactParam.getGender());
        entity.setTitle(contactParam.getTitle());
        entity.setType(contactParam.getType());
        entity.setCity(contactParam.getCity());
        entity.setStreet(contactParam.getStreet());
        entity.setState(contactParam.getState());
        entity.setUnit(contactParam.getUnit());
        entity.setZipCode(contactParam.getZipCode());

        List<CommunicationEntity> communicationEntities = communicationRepository.findAllByContactId(id);
        List<CommunicationEntity> updatedCommunication = mapper.mapAsList(contactParam.getCommunication(), CommunicationEntity.class);

        updatedCommunication.forEach(communication -> {
            communicationEntities.forEach(communicationEntity -> {
                communicationEntity.setPreferred(communication.isPreferred());
                communicationEntity.setType(communication.getType());
                communicationEntity.setValue(communication.getValue());
            });
        });
        entity.setCommunication(communicationEntities);
        entity = contactRepository.save(entity);

        return mapper.map(entity, Contact.class);
    }
}
