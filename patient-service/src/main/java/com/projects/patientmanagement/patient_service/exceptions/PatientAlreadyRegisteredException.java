package com.projects.patientmanagement.patient_service.exceptions;

public class PatientAlreadyRegisteredException extends RuntimeException {
    public PatientAlreadyRegisteredException(String message) {
        super(message);
    }
}
