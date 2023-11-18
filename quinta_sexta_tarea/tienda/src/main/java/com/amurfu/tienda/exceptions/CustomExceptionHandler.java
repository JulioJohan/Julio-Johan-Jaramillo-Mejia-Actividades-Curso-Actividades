package com.amurfu.tienda.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//Esto le dice spring que se utilizara en todos los controladores
// para el manejo de excepciones
@ControllerAdvice
public class CustomExceptionHandler {


//    La clase MethodArgumentNotValidException.class es la excepcion de validation de spring
//    ExceptionHandler nos dice que debe ser manejado los errores por MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
// El response status envia un bad request
    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    El response body ayudará a enviar el mensaje que encontro
    @ResponseBody
    public ErrorResponse handleValidationException(MethodArgumentNotValidException exception){
//        Obtiene todos los errors exception.getBindingResult(). de la validacion de spring
//        getFieldError obtiene el primer error de campo si hay errores de campo en el resultado de la validación.
        FieldError fieldError = exception.getBindingResult().getFieldError();
//       Obtiene el mensaje de error predeterminado para este error de campo. Este mensaje fue definido en la anotación de validación en tu clase de modelo
        String errorMessage = fieldError.getDefaultMessage();
        return new ErrorResponse(errorMessage);
    }
}
