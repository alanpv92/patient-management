package com.projects.patientmanagement.patient_service.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaConfiguration {

    @Bean
    public NewTopic patientCreatedTopic(){
        return TopicBuilder.name("patient_created_topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
