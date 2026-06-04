package com.projects.patientmanagement.patient_service.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "registered_date", nullable = false)
    private LocalDate registeredDate;

//    @CreationTimestamp
//    @Column(name = "created_date", updatable = false)
//    private LocalDateTime createdDate;
//
//    @UpdateTimestamp
//    @Column(name = "last_modified_date")
//    private LocalDateTime lastModifiedDate;
}