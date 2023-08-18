package com.heavyrent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MsgWithReqStatusResponse {
	
	private String message;
	private boolean responseStatus;
}
