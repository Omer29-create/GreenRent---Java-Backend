package com.greenrent.exception.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

// olusan exception'lari throw ettigimiz client'a gönderilecek mesaj icin bir error sinifi yazdik
public class ApiResponseError {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;
    private String requestURL;

    private ApiResponseError() {
        timestamp = LocalDateTime.now();
    }

    public ApiResponseError(HttpStatus status) {
        this();
        this.status = status;
    }

    public ApiResponseError(HttpStatus status, String message, String requestURL) {
        this(status);
        this.message = message;
        this.requestURL = requestURL;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
}
