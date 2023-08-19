package com.heavyrent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class EmailPasswordDTO {
	
	private String email;
	private String Password;
	private String oldPassword;
	
}
