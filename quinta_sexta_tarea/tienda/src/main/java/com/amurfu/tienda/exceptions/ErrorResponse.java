package com.amurfu.tienda.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse {

    private String message;

    private String status;

    private Integer code;


    public ErrorResponse (String message){
        this.message = message;
    }

    public ErrorResponse(HttpStatus httpStatus,String message) {
        this.message = message;
        this.status = httpStatus.name();
        this.code = httpStatus.value();
    }
}
