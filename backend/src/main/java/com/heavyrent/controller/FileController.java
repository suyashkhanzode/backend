package com.heavyrent.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.heavyrent.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private FileService service;
	
	@PostMapping(value = "/{eqpid}/image1",consumes = MediaType.ALL_VALUE)
	public String uploadImg1(@PathVariable long eqpid, @RequestParam("img1") MultipartFile img1) throws  IOException
	{
		 String msg =  service.uploadImg1(eqpid, img1);
		 
		 if(msg != null)
		 {
			 return msg;
		 }
		 else {
			 return "File Not Uploaded";
		 }
	}
	
	@GetMapping(value = "/image1/{eqpid}",produces = MediaType.ALL_VALUE )
	public byte[] doenloadImg1(@PathVariable long eqpid) throws IOException 
	{
		       byte[] img =   service.downloadImg1(eqpid);
		       
		       if(img != null)
		       {
		    	   return img;
		       }
		       else {
		            return null;
		       }
		
	}

}
