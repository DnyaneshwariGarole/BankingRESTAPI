package com.Spring.LayerArchiteture.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Spring.LayerArchiteture.dto.BankDto;
import com.Spring.LayerArchiteture.entities.Bank;


@Component
public class BankMapper
{
	@Autowired
	private  ModelMapper mapper;
	
    public Bank toEntity(BankDto dto)
    {
    	return mapper.map(dto, Bank.class);
    }
    
    public  BankDto toDto(Bank bank)
    {
    	return mapper.map(bank, BankDto.class);
    }

}
