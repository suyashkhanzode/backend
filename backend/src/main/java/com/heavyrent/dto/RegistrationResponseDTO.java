package com.heavyrent.dto;

import com.heavyrent.pojo.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class RegistrationResponseDTO {

	private Long userId;
	
	private String name;
	private String address;
	private String mobileNo;  
	private String email;
	
	@JsonIgnore
	private String password;
	
	private RoleType role;
    private String pin;
	private String url;
	private String cinNo;
}
