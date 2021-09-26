package com.example.demo.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {CrudException.class})
	public ResponseEntity<Object> handleInsightException(CrudException crudException, WebRequest request, HttpServletResponse response) {
		return ResponseEntity
				.status(crudException.getCode())
				.contentType(MediaType.APPLICATION_JSON)
                .body(ExceptionResponseInfo
                        .builder()
                        .reason(crudException.getMessage())
                        .build());
	}
}
