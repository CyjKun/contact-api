package com.ms3.contactapi.api.persistence.repository;

import com.ms3.contactapi.api.persistence.ContactEntity;
import com.ms3.contactapi.common.annotation.DataRepository;
import org.springframework.data.jpa.repository.JpaRepository;

@DataRepository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
