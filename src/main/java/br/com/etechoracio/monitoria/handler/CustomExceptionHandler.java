package br.com.etechoracio.monitoria.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.etechoracio.monitoria.handler.support.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
		Map<String, String> violations = new HashMap<String, String>();
		List<ObjectError> listErrors = ex.getBindingResult().getAllErrors();
		listErrors.forEach(e -> {
			if (e instanceof FieldError) {
				final FieldError fe = (FieldError) e;
				violations.put(fe.getField(), e.getDefaultMessage());
			} else {
				violations.put(e.getCode(), e.getDefaultMessage());
			}
		});
		return ErrorResponse.builder().message("Verifique os campos!")
        						      .status(HttpStatus.BAD_REQUEST.value())
        						      .violations(violations).build();
    }
	
	
	
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleAllException(Exception ex, WebRequest request) {
        return ErrorResponse.builder().message("Erro inesperado: " + ex.getMessage())
        						      .status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
    }
    
    
    
    
    
}
