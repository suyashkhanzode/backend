package com.heavyrent.pojo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="document_tbl")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "document_id")
	private Long documentId;

	
	@Column(name = "aadhar_doc")
	    private String aadharDoc;
	 
	@Column(name = "pan_doc")
	    private String panDoc;
	
	@Column(name = "ver_doc1")
    private String CommpanyVerDoc1;
	
	@Column(name = "ver_doc2")
    private String CommpanyVerDoc2;
	 
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	 private User user;

	
	 
	 

}
