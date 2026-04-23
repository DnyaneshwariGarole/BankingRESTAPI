package com.Spring.LayerArchiteture.ExceptionHandler;


public class ResourceNotFoundException extends RuntimeException
{
	public ResourceNotFoundException(String message)
	{
		super(message);
	}

}
