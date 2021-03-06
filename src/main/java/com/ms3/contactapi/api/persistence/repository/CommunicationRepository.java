package com.ms3.contactapi.api.persistence.repository;

import com.ms3.contactapi.api.persistence.CommunicationEntity;
import com.ms3.contactapi.common.annotation.DataRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@DataRepository
public interface CommunicationRepository extends JpaRepository<CommunicationEntity, Long> {
    List<CommunicationEntity> findAllByContactId(Long id);

    void deleteByContactId(Long id);
}
