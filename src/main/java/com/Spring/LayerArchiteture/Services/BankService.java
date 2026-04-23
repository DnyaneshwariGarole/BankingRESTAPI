package com.Spring.LayerArchiteture.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.Spring.LayerArchiteture.dto.BankDto;
import com.Spring.LayerArchiteture.dto.UpdateBankTypeRequestDto;

public interface BankService 
{
	//Abstract Service methods:
	public BankDto getBank(int id);
	
	public List<BankDto> getAllBanks();

	
	public BankDto getBankByCode(String Code);
	
	public BankDto getBankByNameAndType(String name, String type);
	
	public Page<BankDto> findBanks(Pageable pageable);
	
	public List<BankDto> addBulkBanks();
	
	public BankDto CreateBank(BankDto bankDto);
	
	public BankDto UpdateBank(int id, BankDto bankDto);
	
	public void deleteBank(int id);
	
	public void deleteAllBanks();

	public BankDto  UpdateBankType(int id, UpdateBankTypeRequestDto dto);



}
