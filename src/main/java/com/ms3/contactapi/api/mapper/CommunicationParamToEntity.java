package com.ms3.contactapi.api.mapper;

import com.ms3.contactapi.api.persistence.CommunicationEntity;
import com.ms3.contactapi.api.request.CommunicationParam;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class CommunicationParamToEntity extends CustomMapper<CommunicationParam, CommunicationEntity> {

    @Override
    public void mapAtoB(CommunicationParam communicationParam,
                        CommunicationEntity communicationEntity,
                        MappingContext context) {
        communicationEntity.setType(communicationParam.getType());
        communicationEntity.setPreferred(communicationParam.isPreferred());
        communicationEntity.setValue(communicationParam.getValue());
    }
}
