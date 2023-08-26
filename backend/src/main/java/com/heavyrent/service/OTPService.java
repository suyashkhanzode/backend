package com.heavyrent.service;

import com.heavyrent.dto.VerifyOTPResponseDTO;

public interface OTPService {
   
	String generateOTP();
    void sendOTPByEmail(String email, String otp);
	void storeOTPInBackend(String email, String otp);
	VerifyOTPResponseDTO verifyOTP(String email, String enteredOTP);
	void updateOtpByEmail(String email, String newOtp);
}