package com.projects.patientmanagement.patient_service.kafka;


import com.patientmangement.patientservice.PatientEvent;
import com.projects.patientmanagement.patient_service.models.PatientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {


    private final KafkaTemplate<String,byte[]> kafkaTemplate;



    public void sendPatientCreatedEvent(PatientEntity patient){
        PatientEvent patientEvent=PatientEvent
                .newBuilder()
                .setPatientId(patient.getId().toString())
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .build();
        kafkaTemplate.send("patient_created_topic",patientEvent.toByteArray());
    }

}
