package com.projects.patientmanagement.patient_service.repository;

import com.projects.patientmanagement.patient_service.models.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, UUID> {

    public Optional<PatientEntity> findByEmail(String email);

    public void deleteByEmail(String email);
}
