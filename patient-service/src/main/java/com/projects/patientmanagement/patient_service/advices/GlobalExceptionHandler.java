package com.projects.patientmanagement.patient_service.advices;


import com.projects.patientmanagement.patient_service.dto.response.ApiErrorResponseDto;
import com.projects.patientmanagement.patient_service.exceptions.PatientAlreadyRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiErrorResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var error = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseEntity.badRequest().body(new ApiErrorResponseDto(error));
    }

    @ExceptionHandler({PatientAlreadyRegisteredException.class})
    public ResponseEntity<ApiErrorResponseDto> handlePatientAlreadyRegisteredException(PatientAlreadyRegisteredException exception) {
        return new ResponseEntity<>(new ApiErrorResponseDto(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
