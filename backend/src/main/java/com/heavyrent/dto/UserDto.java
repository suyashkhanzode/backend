package com.heavyrent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.heavyrent.pojo.RoleType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	@JsonProperty(access = Access.WRITE_ONLY)
	private Long userId;
	private String address;
	private String mobile_no;
	private String pin;
	private String url;
	private String cin_no;
	private String name;
	private String email;
	
	@JsonProperty(access = Access.READ_ONLY)
	private String password;
	private RoleType role;
	
	public UserDto(String address, String mobile_no, String pin, String url, String cin_no, String name, String email,
			String password, RoleType role) {
		super();
		this.address = address;
		this.mobile_no = mobile_no;
		this.pin = pin;
		this.url = url;
		this.cin_no = cin_no;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	
}
