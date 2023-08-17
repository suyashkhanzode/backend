package com.heavyrent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginErrorResponse {

	private String message;
	private boolean RequestStatus;
}
