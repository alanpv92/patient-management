package com.projects.patientmanagement.patient_service.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiErrorResponseDto {

    private String message;
    private LocalDateTime timestamp;
    public ApiErrorResponseDto(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
