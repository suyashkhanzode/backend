package com.heavyrent.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public String uploadImg(long id,MultipartFile img);
	
	
}
