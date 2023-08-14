package com.heavyrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.heavyrent.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private FileService service;
	
	@PostMapping(value = "/{eqpid}/image1",consumes = "multipart/form-data")
	public String uploadImg1(@PathVariable long eqpid, @RequestBody MultipartFile img1)
	{
		 String msg =  service.uploadImg(eqpid, img1);
		 
		 if(msg != null)
		 {
			 return msg;
		 }
		 else {
			 return "File Not Uploaded";
		 }
	}

}
