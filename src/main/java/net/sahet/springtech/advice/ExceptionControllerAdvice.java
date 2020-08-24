package net.sahet.springtech.advice;

import net.sahet.springtech.exception.Error;
import net.sahet.springtech.exception.RateNotFoundException;
import net.sahet.springtech.exception.RequestValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = RateNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    Error notFoundException(RateNotFoundException exception) {
        return new Error(404, "Message !!! " + exception.getMessage());
    }


    @ExceptionHandler(value = RequestValidationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public @ResponseBody
    Error validationException(RequestValidationException exception) {
        return new Error(422, "Message !!! " + exception.getMessage());
    }
}
