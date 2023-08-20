package com.heavyrent;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;










@SpringBootApplication

public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		//Strict mode => While mapping , src prop names n data types MUST with dest type
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper;
		
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		return new BCryptPasswordEncoder();
//	
//	}
//	
//	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	String password = "password";
//	String encodedPassword = passwordEncoder.encode(password);
//
//	private void sysout() {
//		System.out.println("Password is         : " + password);
//		System.out.println("Encoded Password is : " + encodedPassword);
//		System.out.println();
//
//		
//		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
//		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
//
//	}
	

}
