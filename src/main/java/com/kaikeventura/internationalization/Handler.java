package com.kaikeventura.internationalization;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
public class Handler {

    private final MessageSource messageSource;

    public Handler(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> exception(MethodArgumentNotValidException exception, Locale locale) {
        String errorCode = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .findFirst().orElse("ERROR-XPTO");

        return ResponseEntity.ok(Map.of("error", messageSource.getMessage(errorCode, null, locale)));
    }
}
