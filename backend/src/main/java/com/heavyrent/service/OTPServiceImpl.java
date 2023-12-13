package com.heavyrent.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.heavyrent.dao.OTPDao;
import com.heavyrent.dto.VerifyOTPResponseDTO;
import com.heavyrent.pojo.OTPRecord;

//import jakarta.transaction.Transactional;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Random;

@Service
public class OTPServiceImpl implements OTPService {
	
    private static final String DIGITS = "0123456789";
    private static final int OTP_LENGTH = 4;
    
    // In-memory storage
    //private final Map<String, String> otpStorage = new HashMap<>(); // In-memory storage
   

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    private final OTPDao otpDao;
    
    @Autowired
    public OTPServiceImpl(JavaMailSender javaMailSender,OTPDao otpDao) {
        this.javaMailSender = javaMailSender;
        this.otpDao = otpDao;
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
	public void sendOTPByEmail(String email, String otp) {
		
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);

        javaMailSender.send(message);
		
	}
	
    @Override
    @Transactional
    public void storeOTPInBackend(String email, String otp) {
       // otpStorage.put(email, otp);
    	 OTPRecord otpRecord = new OTPRecord();
         otpRecord.setEmail(email);
         otpRecord.setOtp(otp);
         otpRecord.setTimestamp(LocalDateTime.now().plusMinutes(5)); // OTP validity period

         otpDao.save(otpRecord);
    }
    
    
	 //========================= To Receive and Verify OTP Entered by user ===================================== ===
    
    @Override
    @Transactional(readOnly = true)
    public VerifyOTPResponseDTO verifyOTP(String email, String enteredOTP) {
        Optional<OTPRecord> otpRecordOptional = otpDao.findLatestValidOTPByEmail(email);

        VerifyOTPResponseDTO response = new VerifyOTPResponseDTO();
        response.setEmail(email);

      if (otpRecordOptional.isPresent()) {
            OTPRecord otpRecord = otpRecordOptional.get();

          if (otpRecord.getOtp().equals(enteredOTP)) {
               if (otpRecord.getTimestamp().isAfter(LocalDateTime.now())) {
                    response.setSuccess(true);
                    response.setMessage("OTP verification succeeded!");
                } 
          
               else {
                    response.setSuccess(false);
                    response.setMessage("OTP has expired.");	
                }
           } 
         else {
                response.setSuccess(false);
                response.setMessage("Invalid OTP entered.");
            }
        } 
      else {
            response.setSuccess(false);
            response.setMessage("No valid OTP found for this email.");
        }

        return response;
    }


	
	@Override
	@Transactional
	public void updateOtpByEmail(String email, String newOtp) {
		otpDao.updateOtpByEmail(email, newOtp);
		
	}

	





	
}
