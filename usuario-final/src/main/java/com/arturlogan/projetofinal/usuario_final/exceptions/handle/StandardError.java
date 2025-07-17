package com.arturlogan.projetofinal.usuario_final.exceptions.handle;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class StandardError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    private List<FieldErrorDto> fieldErrors;


    @Data
    @AllArgsConstructor
    public static class FieldErrorDto{
        private String field;
        private String message;
        private Object rejectedValue;
    }
}
