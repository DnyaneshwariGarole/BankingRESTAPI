package com.Spring.LayerArchiteture.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Version;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bank
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Version
	private Integer version;
	
	@Column(nullable = false, unique = true) //to make a column as not null
	private String name;
	
	@Column(nullable = false, unique = true)
	private String bankCode;
	
//	@Column(nullable = false, unique = true)
//	private String ifscPrefix;
	
//	@Column(nullable = false, unique = true)
//	private String type;
	
	@Column(nullable = false)
	private String type;

	
	@CreationTimestamp
	private LocalDateTime createdAt;   //used to store local date & time
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Bank(String name, String bankCode, String type) {
	
		this.name = name;
		this.bankCode = bankCode;
		this.type = type;
	}   
	
	

}
