package com.ms3.contactapi.api.persistence;

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
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@ToString(onlyExplicitlyIncluded = true)
public class CommunicationEntity {
    /**
     * Database identity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Timestamp on when this entity is saved in the database for the first time.
     */
    @CreationTimestamp
    @Column(updatable = false)
    private Instant createDate;

    /**
     * Timestamp on when this entity is last updated and the version column incremented.
     */
    @UpdateTimestamp
    @Column
    private Instant modifyDate;

    @CreatedBy
    @Column(updatable = false)
    private UUID createdBy;

    @LastModifiedBy
    @Column
    private UUID lastModifiedBy;

    @Column
    private String type;

    @Column
    private String value;

    @Column
    private boolean preferred;

}
