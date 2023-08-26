package com.heavyrent.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.heavyrent.dto.VerifyOTPResponseDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OTPServiceImpl implements OTPService {
	
    private static final String DIGITS = "0123456789";
    private static final int OTP_LENGTH = 6;
    
    // In-memory storage
    private final Map<String, String> otpStorage = new HashMap<>(); // In-memory storage
   

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    public OTPServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    
    //======================= To check if entered email already exist in database ======================
    
//  @Override
//  public boolean isEmailAlreadyRegistered(String email) {
//      return userRepository.findByEmail(email) != null;
//  }
 
   //========================= To Generate and Send OTP via Email ===================================== 
    
	@Override
	public String generateOTP() {
	    // Implement OTP generation logic (e.g., using a random number generator)
        // Return the generated OTP
    	 Random random = new Random();
         StringBuilder otp = new StringBuilder(OTP_LENGTH);
         
         for (int i = 0; i < OTP_LENGTH; i++) {
             otp.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
         }
         System.out.println(otp.toString());
         return otp.toString();
	}
    
    @Override
    public void storeOTPInBackend(String email, String otp) {
        otpStorage.put(email, otp);
    }

	@Override
	public void sendOTPByEmail(String email, String otp) {
		
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);

        javaMailSender.send(message);
		
	}
    
    
	 //========================= To Receive and Verify OTP Entered by user ===================================== ===
    
	  @Override
	    public VerifyOTPResponseDTO verifyOTP(String email, String enteredOTP) {
	        String storedOTP = otpStorage.get(email);

	        VerifyOTPResponseDTO response = new VerifyOTPResponseDTO(email, "");

	        if (storedOTP != null && storedOTP.equals(enteredOTP)) {
	            response.setMessage("OTP verification succeeded!");
	        } else {
	            response.setMessage("OTP verification failed!");
	        }

	        return response;
	    }

	
	
	





	
}
