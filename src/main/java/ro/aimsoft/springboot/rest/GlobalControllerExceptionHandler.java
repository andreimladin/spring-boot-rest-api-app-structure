package ro.aimsoft.springboot.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.aimsoft.springboot.rest.controller.error.ApiError;
import ro.aimsoft.springboot.rest.exception.business.PatientNotAssurredException;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PatientNotAssurredException.class)
    public ResponseEntity<ApiError> patientNotAssuredException(PatientNotAssurredException e) {
        return new ResponseEntity<>(new ApiError("CNAS-01", "Patient is not assured"), HttpStatus.BAD_REQUEST);
    }
}
