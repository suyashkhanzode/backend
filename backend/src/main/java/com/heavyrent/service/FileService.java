package com.heavyrent.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public String uploadImg1(long id, MultipartFile img) throws IOException;

	public byte[] downloadImg1(long id) throws IOException;

	public String uploadImg2(long id, MultipartFile img) throws IOException;

	public byte[] downloadImg2(long id) throws IOException;

	public String uploadInserInc(long id, MultipartFile img) throws IOException;

	public byte[] downloadInserInc(long id) throws IOException;

	public String uploadRcBook(long id, MultipartFile img) throws IOException;

	public byte[] downloadRcBook(long id) throws IOException;
}
