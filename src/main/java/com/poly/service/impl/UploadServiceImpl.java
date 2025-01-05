package com.poly.service.impl;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poly.service.UploadService;


@Service
public class UploadServiceImpl implements UploadService {
	@Autowired
	ServletContext app;
	
	
//	String realPath="src/main/resources/static/assets/";

	@Override
	public File save(MultipartFile file, String folder) {
//		File pathFile = new File (realPath);
		
		File dir = new File(app.getRealPath("/assets/"+ folder));
		if (!dir.exists()) {
			dir.mkdirs();
		}

		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String n = file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));

		try {
			File savedFile = new File(dir, n);
			file.transferTo(savedFile);
			System.out.println(savedFile.getAbsolutePath());
			return savedFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
