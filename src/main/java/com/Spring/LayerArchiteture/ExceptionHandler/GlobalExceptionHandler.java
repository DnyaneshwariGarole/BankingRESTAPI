package com.Spring.LayerArchiteture.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Spring.LayerArchiteture.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> resourceNotFountHandler(ResourceNotFoundException e)
	{
		ErrorResponseDto dto = new ErrorResponseDto();
		
		dto.setStatus(HttpStatus.NOT_FOUND.value());
		dto.setError("NOT_FOUND");
		dto.setMessage(e.getMessage());
		dto.setTimestamp(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
	} 

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> genericExceptionHandler(Exception e)
	{
		ErrorResponseDto dto = new ErrorResponseDto();
		
		dto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		dto.setError("INTERNAL_SERVER_ERROR");
		dto.setMessage(e.getMessage());
		dto.setTimestamp(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
	} 

}
