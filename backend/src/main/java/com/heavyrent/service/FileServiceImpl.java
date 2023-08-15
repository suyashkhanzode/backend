package com.heavyrent.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
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

	@Value("${file.images.location}")
	private String folderlocation;

	@PostConstruct
	public void init() {
		System.out.println("In init " + folderlocation);

		File folder = new File(folderlocation);

		if (folder.exists()) {
			System.out.println("Folder Alredy Exist");
		} else {
			folder.mkdir();
			System.out.println("New Folder Created " + folder);
		}
	}

	@Override
	public String uploadImg1(long id, MultipartFile img) throws IOException {

		Equipment eqp = dao.findById(id).orElseThrow(() -> new RuntimeException());

		String path = folderlocation.concat(img.getOriginalFilename());

		FileUtils.writeByteArrayToFile(new File(path), img.getBytes());

		eqp.setEquip_img1(path);

		dao.save(eqp);

		return path;
	}

	@Override
	public byte[] downloadImg1(long id) throws IOException {

		Equipment eqp = dao.findById(id).orElseThrow();

		if (eqp.getEquip_img1() != null) {
			return FileUtils.readFileToByteArray(new File(eqp.getEquip_img1()));
		}

		return null;
	}

	@Override
	public String uploadImg2(long id, MultipartFile img) throws IOException {

		Equipment eqp = dao.findById(id).orElseThrow(() -> new RuntimeException());

		String path = folderlocation.concat(img.getOriginalFilename());

		FileUtils.writeByteArrayToFile(new File(path), img.getBytes());

		eqp.setEquip_img2(path);

		dao.save(eqp);

		return path;
	}

	@Override
	public byte[] downloadImg2(long id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String uploadInserInc(long id, MultipartFile img) throws IOException {

		Equipment eqp = dao.findById(id).orElseThrow(() -> new RuntimeException());

		String path = folderlocation.concat(img.getOriginalFilename());

		FileUtils.writeByteArrayToFile(new File(path), img.getBytes());

		eqp.setEquip_img1(path);

		dao.save(eqp);

		return path;
	}

	@Override
	public byte[] downloadInserInc(long id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String uploadRcBook(long id, MultipartFile img) throws IOException {

		Equipment eqp = dao.findById(id).orElseThrow(() -> new RuntimeException());

		String path = folderlocation.concat(img.getOriginalFilename());

		FileUtils.writeByteArrayToFile(new File(path), img.getBytes());

		eqp.setEquip_img1(path);

		dao.save(eqp);

		return path;
	}

	@Override
	public byte[] downloadRcBook(long id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
