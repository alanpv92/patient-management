package com.projects.patientmanagement.patient_service.dto.patient;


import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PatientResponseDto {

    private UUID id;

    private String name;

    private String email;

    private String address;

    private LocalDate dateOfBirth;
}
