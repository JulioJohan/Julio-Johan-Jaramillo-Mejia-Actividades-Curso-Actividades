package com.amurfu.tienda.exceptions;

import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ErrorResponse handleBussinessException(BusinessException exception){
        return new ErrorResponse(exception.getHttpStatus(),exception.getMessage());
    }


    @ExceptionHandler(UnexpectedTypeException.class)
    @ResponseBody
    public ErrorResponse handleTypeValidationException(UnexpectedTypeException exception){
        return new ErrorResponse(HttpStatus.BAD_REQUEST,"Upps, el tipo de dato es invalido");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ErrorResponse handleArgumentTypeValidationException(MethodArgumentTypeMismatchException exception){
        return new ErrorResponse(HttpStatus.BAD_REQUEST,"Upps, el tipo de dato es invalido");
    }


}
