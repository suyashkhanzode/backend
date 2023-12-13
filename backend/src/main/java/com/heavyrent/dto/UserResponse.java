package com.heavyrent.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heavyrent.pojo.Document;
import com.heavyrent.pojo.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	
	private Long userId;
	private String address;
	private String mobile_no;
	private String pin;
	private String url;
	private String cin_no;
	private String name;
	private String email;
	@JsonIgnore
	private String password;
	private RoleType role;
	//private Document document;
	
}
