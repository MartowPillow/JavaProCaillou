package com.example.demo.controller;

import com.example.demo.models.ApiError;
import com.example.demo.models.exceptions.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ErrorController extends AbstractErrorController {

    @Autowired
    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping("/error")
    @ResponseBody
    public ResponseEntity<?> handleError(HttpServletRequest request) {
        Map<String, Object> attributes = this.getErrorAttributes(request, ErrorAttributeOptions.defaults());

        return createResponseEntity(this.getStatus(request),
                (String) attributes.get("error"),
                new Exception("Api Error"));
    }

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> entityNotFound(ApiException ex) {
        return createResponseEntity(HttpStatus.NOT_FOUND,
                ex.getLocalizedMessage(),
                ex);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> genericException(Exception ex) {
        return createResponseEntity(HttpStatus.NOT_FOUND,
                ex.getLocalizedMessage(),
                ex);
    }

    private ResponseEntity<ApiError> createResponseEntity(HttpStatus status, String msg, Exception ex) {
        return ResponseEntity.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiError(status, msg, ex));
    }

}
