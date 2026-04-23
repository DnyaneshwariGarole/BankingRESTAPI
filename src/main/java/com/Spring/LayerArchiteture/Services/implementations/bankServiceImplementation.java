package com.Spring.LayerArchiteture.Services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.internal.bytebuddy.asm.Advice.Exit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.Spring.LayerArchiteture.ExceptionHandler.ResourceNotFoundException;
import com.Spring.LayerArchiteture.Repositories.BankRespository;
import com.Spring.LayerArchiteture.Services.BankService;
import com.Spring.LayerArchiteture.dto.BankDto;
import com.Spring.LayerArchiteture.dto.UpdateBankTypeRequestDto;
import com.Spring.LayerArchiteture.entities.Bank;
import com.Spring.LayerArchiteture.mappers.BankMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor    //its work like constructor ...we can use only while we used lombok
@Transactional
public class bankServiceImplementation implements BankService
{
	
	private final BankRespository bankRepository;
	
	private final BankMapper mapper;
	
	//Override service methods
	@Override
	public BankDto getBank(int id)
	{
		Bank bank = bankRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bank Not Found!"));
		return mapper.toDto(bank);
			
	}
	
	 @Override
	    public List<BankDto> getAllBanks() {
		 List<Bank> banks = bankRepository.findAll();
	        return banks.stream().map(bank -> mapper.toDto(bank)).toList();
	 }
	 
	@Override
	public BankDto getBankByNameAndType(String name, String type)
	{

		Bank bank = bankRepository.getBankByNameAndType(name, type);
		
		if (bank == null) {
	        throw new ResourceNotFoundException("Bank not found with name " + name + " and type " + type);
	    }
		
		return mapper.toDto(bank);
	}
	

	@Override
	public BankDto getBankByCode(String code)
	{
		Optional<Bank> bank = bankRepository.findBybankCode(code);
		if(bank.isPresent())
		{
			return mapper.toDto(bank.get());
		}
		return null;
	}

	@Override
	public Page<BankDto> findBanks(Pageable pageable)
	{
		 Page<Bank> banks = bankRepository.findAll(pageable);
		return banks.map(mapper::toDto);
     }

	@Override
	public BankDto CreateBank(BankDto bankDto) {
		 Bank newBank = bankRepository.save(mapper.toEntity(bankDto));
		return mapper.toDto(newBank);
	}
	
	

	@Override
	public BankDto UpdateBank(int id, BankDto bankDto) {
		// fetching
		Bank existingBank = bankRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Bank Not Found"));
		
		//update
		existingBank.setName(bankDto.getName());
		existingBank.setBankCode(bankDto.getBankCode());
		existingBank.setType(bankDto.getType());
		
		 Bank UpdatedBank= bankRepository.save(existingBank);
		 
		return mapper.toDto(UpdatedBank);
	}

	@Override
	public void deleteBank(int id) {
		// call method
		bankRepository.deleteById(id);
		
	}

	@Override
	public void deleteAllBanks() {
		bankRepository.deleteAll();
		
	}

	@Override
	public BankDto UpdateBankType(int id, UpdateBankTypeRequestDto dto)
	{
		Bank existingBank = bankRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bank not found"));
		
		existingBank.setType(dto.getType());
		
		//bank updateBank = bankRepository.save(existingBank);
		
		return mapper.toDto(existingBank);
	}

	@Override
	public List<BankDto> addBulkBanks() {
		List<Bank> banks = new ArrayList<Bank>();
		banks.add(new Bank("Swiss Bank", "SWISS", "International"));
		
		banks.add(new Bank("Canara Bank", "CAN", "Private"));
		
		banks.add(new Bank("City Bank", "CITY", "State"));
		
		banks.add(new Bank("Panjab National Bank", "PNB", "State"));
		
		
		bankRepository.saveAll(banks);
		return banks.stream().map(mapper::toDto).toList();
		
	}
	
}
