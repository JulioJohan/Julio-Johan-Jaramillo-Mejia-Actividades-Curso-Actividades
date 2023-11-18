package com.amurfu.tienda.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BusinessException extends RuntimeException{

    /**
     * Numero serial
     */
    private static final long serialVersionUID = -6654256023230766061L;

    /*
     * Atributo HttpStatus
     */
    private final HttpStatus httpStatus;

    /**
     * Codigo de respuesta
     */
    private final String message;

    public BusinessException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
