package com.heavyrent.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="document_tbl")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long d_id;
	
	
	    private String adhar;
	 
	 
	    private String pan;
	    
	 @OneToOne(mappedBy="document")
	 private User user;

	
	 
	 

}
