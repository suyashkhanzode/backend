package com.heavyrent.dao;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.heavyrent.pojo.OTPRecord;

@Repository
public interface OTPDao extends JpaRepository<OTPRecord, Long> {

    Optional<OTPRecord> findLatestValidOTPByEmail(String email);
  //SELECT * FROM otp_record WHERE email = :email AND timestamp > CURRENT_TIMESTAMP ORDER BY timestamp DESC LIMIT 1
    
    @Modifying
    @Transactional
    @Query("DELETE FROM OTPRecord WHERE timestamp < CURRENT_TIMESTAMP")
    void deleteExpiredRecords();
    
    // Method to update OTP value by email
    @Modifying
    @Transactional
    @Query("UPDATE OTPRecord o SET o.otp = :newOtp WHERE o.email = :email")
    void updateOtpByEmail(@Param("email") String email, @Param("newOtp") String newOtp);
}