package com.heavyrent.dto;

import com.heavyrent.pojo.RoleType;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDTO {

	@NotNull
	private String name;
	
	@NotNull
	private String address;
	
	@NotNull
	private String pin;
	
	@NotNull
	private String mobileNo;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	private RoleType role;
   
	private String url;
	private String cinNo;
	
}
