package com.Spring.LayerArchiteture.Repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Spring.LayerArchiteture.entities.Bank;



@Repository
public interface BankRespository extends JpaRepository<Bank, Integer>
{
	public Optional<Bank> findBybankCode(String bankCode);
	
	//internally execute this query 
	//select b from Bank  b where b.name = :name;
	
	
	@Query("Select b from Bank b where b.name=:name and b.type=:bankType")
	public Bank getBankByNameAndType(String name,@Param("bankType") String type);
}
