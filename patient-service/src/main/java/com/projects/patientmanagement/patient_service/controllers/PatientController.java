package com.projects.patientmanagement.patient_service.controllers;

import com.projects.patientmanagement.patient_service.dto.patient.PatientCreationRequestDto;
import com.projects.patientmanagement.patient_service.dto.patient.PatientResponseDto;
import com.projects.patientmanagement.patient_service.services.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PatientResponseDto> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PatientResponseDto savePatient(@RequestBody @Valid PatientCreationRequestDto patientCreationRequestDto) {
        return patientService.createPatient(patientCreationRequestDto);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deletePatientByEmail(@PathVariable("email") String email) {
        patientService.deletePatientByEmail(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
