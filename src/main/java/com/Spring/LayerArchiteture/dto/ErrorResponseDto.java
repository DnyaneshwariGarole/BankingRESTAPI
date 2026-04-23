package com.Spring.LayerArchiteture.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto
{
	private int status;
	private String error;
	private String message;
	private LocalDateTime timestamp;

}
