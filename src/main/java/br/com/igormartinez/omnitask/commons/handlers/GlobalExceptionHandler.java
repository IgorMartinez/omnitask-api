package br.com.igormartinez.omnitask.commons.handlers;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.igormartinez.omnitask.commons.exceptions.GenericException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
    private static final String GENERIC_ERROR_MESSAGE = 
        "An unexpected error occurred. Please try again later or contact support if the problem persists.";
    
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(GenericException.class)
    public ProblemDetail handleGenericException(GenericException ex) {
        HttpStatus status = HttpStatus.valueOf(ex.getStatusCode());
        String detail = status.is5xxServerError() 
            ? GENERIC_ERROR_MESSAGE
            : messageSource.getMessage(ex.getKey(), null, LocaleHandler.getContext());
        
        return ProblemDetail.forStatusAndDetail(status, detail);
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleUnexpectedException(Exception ex) {
        return ProblemDetail.forStatusAndDetail(
            HttpStatus.INTERNAL_SERVER_ERROR,
            GENERIC_ERROR_MESSAGE
        );
    }
}
