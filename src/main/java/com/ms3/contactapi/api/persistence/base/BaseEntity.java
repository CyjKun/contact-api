package com.ms3.contactapi.api.persistence.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class BaseEntity {

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
}
