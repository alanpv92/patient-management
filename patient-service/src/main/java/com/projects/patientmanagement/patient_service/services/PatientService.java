package com.projects.patientmanagement.patient_service.services;

import com.patientmangement.billing.BillingServiceGrpc;
import com.patientmangement.billing.CreateBillingAccountRequest;
import com.projects.patientmanagement.patient_service.dto.patient.PatientCreationRequestDto;
import com.projects.patientmanagement.patient_service.dto.patient.PatientResponseDto;
import com.projects.patientmanagement.patient_service.exceptions.PatientAlreadyRegisteredException;
import com.projects.patientmanagement.patient_service.kafka.KafkaProducer;
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
    private final BillingServiceGrpc.BillingServiceBlockingStub billingServiceBlockingStub;
    private final KafkaProducer  kafkaProducer;

    public Optional<PatientEntity> getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public PatientResponseDto createPatient(PatientCreationRequestDto patientCreationRequestDto) {
        if (patientRepository.findByEmail(patientCreationRequestDto.getEmail()).isPresent()) {
            throw new PatientAlreadyRegisteredException(ErrorMessageConstants.PATIENT_NOT_FOUND);
        }
         final PatientEntity savedPatient=patientRepository.save(patientMapper.fromDto(patientCreationRequestDto));
         billingServiceBlockingStub.createBillingAccount(CreateBillingAccountRequest.newBuilder().setPatientId(savedPatient.getId().toString()).setName(savedPatient.getName()).setEmail(savedPatient.getName()).build());
         kafkaProducer.sendPatientCreatedEvent(savedPatient);
         return patientMapper.fromEntity(savedPatient);
    }

    public List<PatientResponseDto> getAllPatients() {
        return patientRepository.findAll().stream().map(patientMapper::fromEntity).toList();
    }

    @Transactional
    public void  deletePatientByEmail(String email) {
        patientRepository.deleteByEmail(email);
    }
}
