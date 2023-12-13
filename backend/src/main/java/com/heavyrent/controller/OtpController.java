package com.heavyrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.heavyrent.dto.EmailRequestDTO;
import com.heavyrent.dto.EmailResponseDTO;
import com.heavyrent.dto.VerifyOTPRequestDTO;
import com.heavyrent.dto.VerifyOTPResponseDTO;
import com.heavyrent.service.OTPService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OtpController {
	
	@Autowired
    private OTPService otpService;
	
	String storedOtp;
    
    public OtpController(OTPService otpService) {
        this.otpService = otpService;
    }

    @PostMapping("/send-otp")
    public ResponseEntity<EmailResponseDTO> sendOTP(@RequestBody EmailRequestDTO emailRequest) {
        String email = emailRequest.getEmail();

        // Generate OTP
        String otp = otpService.generateOTP();

        // Store OTP in cache with the email
        otpService.storeOTPInBackend(email, otp);

        // Send OTP to the user's email
        otpService.sendOTPByEmail(email, otp);

        String responseMessage = "OTP sent successfully!";
        EmailResponseDTO responseDTO = new EmailResponseDTO(email, responseMessage);

        return ResponseEntity.ok(responseDTO);
    }
    
    
    @PostMapping("/resend-otp")
    public ResponseEntity<EmailResponseDTO> resendOTP(@RequestBody EmailRequestDTO emailRequest) {
        String email = emailRequest.getEmail();

        // Generate OTP
        String otp = otpService.generateOTP();

        // Store OTP in database with the email
        otpService.storeOTPInBackend(email, otp);

        // Send OTP to the user's email
        otpService.sendOTPByEmail(email, otp);
        
        //Update resent OTP value in database
        otpService.updateOtpByEmail(email, otp);

        String responseMessage = "OTP sent successfully!";
        EmailResponseDTO responseDTO = new EmailResponseDTO(email, responseMessage);

        return ResponseEntity.ok(responseDTO);
    }
    
    @PostMapping("/verify-otp")
    public ResponseEntity<VerifyOTPResponseDTO> verifyOTP(@RequestBody VerifyOTPRequestDTO request) {
        
    	String email = request.getEmail();
        String enteredOTP = request.getEnteredOTP();

        VerifyOTPResponseDTO response = otpService.verifyOTP(email, enteredOTP);

        return ResponseEntity.ok(response);
    }
      
}
