package com.arturlogan.projetofinal.usuario_final.exceptions;

import com.arturlogan.projetofinal.usuario_final.exceptions.handle.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handle(Exception exception, HttpServletRequest request){

        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        standardError.setMessage(exception.getLocalizedMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<StandardError> handle(UsuarioNotFoundException exception, HttpServletRequest request){

        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        standardError.setMessage(exception.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleValidationExceptions(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ){

        List<StandardError.FieldErrorDto> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> new StandardError.FieldErrorDto(
                        error.getField(),
                        error.getDefaultMessage(),
                        error.getRejectedValue()))
                .collect(Collectors.toList());

        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(HttpStatus.BAD_REQUEST.value());
        standardError.setError("Erro de validação");
        standardError.setMessage("Campos Inválidos");
        standardError.setPath(request.getRequestURI());
        standardError.setFieldErrors(errors);

        return ResponseEntity.badRequest().body(standardError);
    }
}
