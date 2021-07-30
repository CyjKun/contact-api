package com.ms3.contactapi.api.persistence;

import com.ms3.contactapi.api.model.Address;
import com.ms3.contactapi.api.model.Communication;
import com.ms3.contactapi.api.model.Identification;
import com.ms3.contactapi.api.persistence.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;


@Entity
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ContactEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String dateOfBirth;

    @Column
    private String gender;

    @Column
    private String title;

    @Column
    private String type;

    @Column
    private String number;

    @Column
    private String street;

    @Column
    private String unit;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zipCode;

//    @OneToMany
//    private Set<CommunicationEntity> communication;
}
