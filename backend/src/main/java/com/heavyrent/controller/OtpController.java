package com.heavyrent.controller;

import com.heavyrent.service.EmailService;
import  com.heavyrent.pojo.OtpGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/otp")
public class OtpController {
	
	@Autowired
    private EmailService emailService;
	String storedOtp ;

    public OtpController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send/{email}")
    public String sendOtp(@PathVariable String email) {
        // Generate OTP
        storedOtp = OtpGenerator.generateOtp();
       //System.out.println("In post");
        
        // Send OTP via email
        emailService.sendOtpEmail(email, storedOtp);

        return "OTP sent successfully";
    }
    
    @PostMapping("/verifyotp/{otpEntered}")
    public String verifyOTP( @PathVariable String otpEntered) {
      
        
        if (otpEntered == null) {
            return "User not found";
        }
        
        else if (storedOtp != null && storedOtp.equals(otpEntered)) {
            // OTP matches, perform your desired action
        	 storedOtp = null;
            return "OTP verification successful";
        } 
        else 
        {
        	storedOtp = null;
            return "Invalid OTP";
        } 
       
    }
  
   
}
