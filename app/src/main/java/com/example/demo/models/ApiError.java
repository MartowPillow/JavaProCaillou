package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.text.MessageFormat;
import java.time.LocalDateTime;

@Data
public class ApiError implements Serializable {

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime date;

    private HttpStatus status;

    private String message;

    private String apiException;

    protected ApiError() { }

    public ApiError(HttpStatus status, String message, Exception apiException) {
        this.status = status;
        this.message = message;
        this.date = LocalDateTime.now();
        this.apiException = (apiException == null) ? "" : apiException.getMessage();
    }

    @Override
    public String toString() {
        return MessageFormat.format("ApiError'{'status={0}, message=''{1}'', origin=''{2}'''}'", status, message, apiException.getClass().getName());
    }
}

