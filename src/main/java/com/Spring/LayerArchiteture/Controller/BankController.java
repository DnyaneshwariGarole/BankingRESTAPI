package com.Spring.LayerArchiteture.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.Spring.LayerArchiteture.Repositories.BankRespository;
import com.Spring.LayerArchiteture.Services.BankService;
import com.Spring.LayerArchiteture.dto.BankDto;
import com.Spring.LayerArchiteture.dto.BankResponseDto;
import com.Spring.LayerArchiteture.dto.UpdateBankTypeRequestDto;
import com.Spring.LayerArchiteture.mappers.BankMapper;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "http://localhost:8080")
@RestController      //json format it will send the response
@RequestMapping("/banks")
public class BankController 
{
	
	private BankService bankService;
	
	
	public BankController(BankService bankService)
	{
		this.bankService = bankService;
	}
	
	//handler methods
	
//	@GetMapping("/{id}")
//	public ResponseEntity<BankResponseDto<BankDto>>(@PathVariable int  id)
//	{
//		return bankService.getBank(id);
//		
//		return ResponseEntity.ok(dto2);
//	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<BankResponseDto<BankDto>> getBank(@PathVariable int id)
//	{
//		return ResponseEntity.ok(bankService.getBank(id));)
//	}
//	
	
	 @GetMapping("/{id}")
	    public ResponseEntity<BankDto> getBank(@PathVariable int id) {
	        return ResponseEntity.ok(bankService.getBank(id));
	    }

	@GetMapping
	public ResponseEntity<List<BankDto>> getAllbanks(){
		return ResponseEntity.ok(bankService.getAllBanks());
	}
	
	@GetMapping("name-type/{name}/{type}")
	public ResponseEntity<BankDto>getBankByNameAndType(@PathVariable String name, @PathVariable String type)
	{
		BankDto bank = bankService.getBankByNameAndType(name, type);
		
		return ResponseEntity.ok(bank);
	}
	
	@GetMapping("/pagination")
	public ResponseEntity<List<BankDto>> getBanks(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size, 
			@RequestParam(defaultValue = "name") String sortBy, 
			@RequestParam(defaultValue = "asc") String sortDirection)
	{
	
		Sort sort = sortDirection.equalsIgnoreCase("desc")? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		
		Pageable pageable = PageRequest.of(page, size, sort);
		
		 Page<BankDto> banks = bankService.findBanks(pageable);
		 
		 return ResponseEntity.ok(banks.toList());
	}
	
	
	@PostMapping("/bulk-insert")
	public ResponseEntity<List<BankDto>> addMutlipleBanks()
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bankService.addBulkBanks());
	}
	
	@GetMapping("/bank-code/{code}")
	public ResponseEntity<BankResponseDto<BankDto>> getBankByCode(@PathVariable String code)
	{
		BankResponseDto<BankDto> dto = new BankResponseDto<>();
		BankDto bank = bankService.getBankByCode(code);
		
		if(bank != null)
		{
			dto.setStatus(HttpStatus.OK.value());
			dto.setMessage("Bank fetched Successfully");
			dto.setData(bank);
			
			return ResponseEntity.ok(dto);
		}
		else
		{
			dto.setStatus(HttpStatus.NOT_FOUND.value());
			dto.setMessage("Bank Not Found!!");
			
			return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
		}

	}
	
	
	
	@PostMapping //is used to save new record
	public ResponseEntity<BankDto> createBank(@RequestBody BankDto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(bankService.CreateBank(dto));
	}
	
	@PutMapping("/{id}")  //is used to update
	public ResponseEntity<BankDto> updatBank(@PathVariable int id, @RequestBody BankDto dto)
	{
		return ResponseEntity.ok(bankService.UpdateBank(id, dto));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<BankDto> updateBankType(@PathVariable int id, @RequestBody UpdateBankTypeRequestDto dto )
	{
		return ResponseEntity.ok(bankService.UpdateBankType(id, dto));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBank(@PathVariable int id)
	{
		bankService.deleteBank(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAllBank()
	{
		bankService.deleteAllBanks();
		return ResponseEntity.noContent().build();
			
	}
	

}
