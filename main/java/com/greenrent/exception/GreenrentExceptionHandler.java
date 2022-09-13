package com.greenrent.exception;

import com.greenrent.exception.message.ApiResponseError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GreenrentExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildresponseEntity(ApiResponseError error) {
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ApiResponseError error = new ApiResponseError(HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false));
        return buildresponseEntity(error);
    }

    @ExceptionHandler(ConflictException.class)
    protected ResponseEntity<Object> handleConflictException(ConflictException ex, WebRequest request) {
        ApiResponseError error = new ApiResponseError(HttpStatus.CONFLICT, ex.getMessage(), request.getDescription(false));
        return buildresponseEntity(error);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ApiResponseError error = new ApiResponseError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
        return buildresponseEntity(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, 
                                                                  HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
        ApiResponseError error = new ApiResponseError(HttpStatus.BAD_REQUEST, errors.get(0).toString(), request.getDescription(false));
        return buildresponseEntity(error);
    }
    
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
                                                        HttpStatus status, WebRequest request) {
        ApiResponseError error = new ApiResponseError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
        return buildresponseEntity(error);
    }
    
    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, 
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiResponseError error = new ApiResponseError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getDescription(false));
        return buildresponseEntity(error);
    }
}
