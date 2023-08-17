package com.heavyrent.dto;

import com.heavyrent.pojo.RoleType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
	private Long userId;
	private String address;
	private String mobile_no;
	private String pin;
	private String url;
	private String cin_no;
	private String name;
	private String email;
	private RoleType role;
}
