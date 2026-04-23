package com.Spring.LayerArchiteture.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankResponseDto<T>
{
		private int status;
		private String message;
		private T data;
	

}
