package com.ms3.contactapi.api.persistence;

import com.ms3.contactapi.api.persistence.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
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

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "contact",
            orphanRemoval = true
    )
    private List<CommunicationEntity> communication = new ArrayList<>();
}
