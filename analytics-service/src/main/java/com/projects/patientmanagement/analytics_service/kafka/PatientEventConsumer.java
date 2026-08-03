package com.projects.patientmanagement.analytics_service.kafka;


import com.google.protobuf.InvalidProtocolBufferException;
import com.patientmangement.analyticsservice.PatientEvent;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PatientEventConsumer {


    @KafkaListener(topics = "patient_created_topic", groupId = "analytics-group" )
    public void onPatientEvent(byte[] patientEventByte) throws InvalidProtocolBufferException {
        PatientEvent patientEvent=PatientEvent.parseFrom(patientEventByte);
        System.out.println("Patient event received: " + patientEvent.toString());
    }
}
