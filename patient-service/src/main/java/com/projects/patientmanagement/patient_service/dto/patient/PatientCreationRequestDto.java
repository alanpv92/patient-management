package com.projects.patientmanagement.patient_service.dto.patient;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientCreationRequestDto {


    @NotBlank(message = "name cannot be empty or null")
    private String name;

    @NotBlank(message = "email cannot be empty or null")
    private String email;

    @NotBlank(message = "address cannot be empty or null")
    private String address;

    @NotNull(message = "date_of_birth cannot be null")
    @Past(message = "date_of_birth must be in the past")
    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;


    @NotNull(message = "registration_date cannot be null")
    @PastOrPresent(message = "registration_date cannot be in the future")
    @JsonProperty("registration_date")
    private LocalDate registrationDate;
}
