package com.heavyrent.service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

	@Service
	public class EmailService {
		
	    private final JavaMailSender mailSender;

	    
	    public EmailService(JavaMailSender mailSender) {
	        this.mailSender = mailSender;
	    }

	    public void sendOtpEmail(String toEmail, String otp) {
	    	System.out.println("in service");
	        SimpleMailMessage message = new SimpleMailMessage();
	        System.out.println("After SimpleMailMessage");
	        message.setTo(toEmail);
	        System.out.println("After setTo");
	        message.setSubject("OTP Verification");
	        message.setText("Your OTP is: " + otp);
	        mailSender.send(message);
	    }
	}
	

