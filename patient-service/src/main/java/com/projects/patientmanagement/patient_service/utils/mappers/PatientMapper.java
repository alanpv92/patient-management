package com.projects.patientmanagement.patient_service.utils.mappers;

import com.projects.patientmanagement.patient_service.dto.patient.PatientCreationRequestDto;
import com.projects.patientmanagement.patient_service.dto.patient.PatientResponseDto;
import com.projects.patientmanagement.patient_service.models.PatientEntity;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientResponseDto fromEntity(PatientEntity patientEntity) {
        PatientResponseDto patientResponseDto = new PatientResponseDto();
        patientResponseDto.setId(patientEntity.getId());
        patientResponseDto.setName(patientEntity.getName());
        patientResponseDto.setAddress(patientEntity.getAddress());
        patientResponseDto.setDateOfBirth(patientEntity.getDateOfBirth());
        patientResponseDto.setEmail(patientEntity.getEmail());
       return patientResponseDto;
    }

    public PatientEntity fromDto(PatientCreationRequestDto patientCreationRequestDto) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setName(patientCreationRequestDto.getName());
        patientEntity.setAddress(patientCreationRequestDto.getAddress());
        patientEntity.setDateOfBirth(patientCreationRequestDto.getDateOfBirth());
        patientEntity.setRegisteredDate(patientCreationRequestDto.getRegistrationDate());
        patientEntity.setEmail(patientCreationRequestDto.getEmail());
        return patientEntity;
    }
}
