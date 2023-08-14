package com.heavyrent.service;

import java.io.File;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.heavyrent.dao.EquipmentDao;
import com.heavyrent.pojo.Equipment;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FileServiceImpl implements FileService {

	@Autowired
	private EquipmentDao dao;
	
	@Value("${upload.location.equipment}")
	private String folderlocation;
	
	@PostConstruct
	public void init()
	{
		System.out.println("In init"+folderlocation);
		
		File folder =  new File(folderlocation);
		
		if(folder.exists())
		{
			System.out.println("Folder Alredy Exist");
		}
		else {
			folder.mkdir();
			System.out.println("New Folder Created");
		}
	}
	
	@Override
	public String uploadImg(long id, MultipartFile img) {
		
            
		   Equipment eqp = dao.findById(id).orElseThrow(() -> new RuntimeException());
			
		
		   String path = folderlocation.concat(img.getOriginalFilename());
		
		    eqp.setEquip_img1(path);
		   
		    dao.save(eqp);
		
		return path;
	}
	
	
	
	

	

}
