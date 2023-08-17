package com.heavyrent.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "otprecord_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OTPRecord {

        
	    @Id
	    @Column(length = 50)
	    private String email;
	    
	    @Column(length = 4)
	    private String otp;
	    
	    @Column
	    private LocalDateTime timestamp;
}
