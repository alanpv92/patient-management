package com.projects.patientmanagement.patient_service.services;

import com.projects.patientmanagement.patient_service.dto.patient.PatientCreationRequestDto;
import com.projects.patientmanagement.patient_service.dto.patient.PatientResponseDto;
import com.projects.patientmanagement.patient_service.exceptions.PatientAlreadyRegisteredException;
import com.projects.patientmanagement.patient_service.models.PatientEntity;
import com.projects.patientmanagement.patient_service.repository.PatientRepository;
import com.projects.patientmanagement.patient_service.utils.constants.ErrorMessageConstants;
import com.projects.patientmanagement.patient_service.utils.mappers.PatientMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public Optional<PatientEntity> getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public PatientResponseDto createPatient(PatientCreationRequestDto patientCreationRequestDto) {
        if (patientRepository.findByEmail(patientCreationRequestDto.getEmail()).isPresent()) {
            throw new PatientAlreadyRegisteredException(ErrorMessageConstants.PATIENT_NOT_FOUND);
        }
        return patientMapper.fromEntity(patientRepository.save(patientMapper.fromDto(patientCreationRequestDto)));
    }

    public List<PatientResponseDto> getAllPatients() {
        return patientRepository.findAll().stream().map(patientMapper::fromEntity).toList();
    }

    @Transactional
    public void  deletePatientByEmail(String email) {
        patientRepository.deleteByEmail(email);
    }
}
