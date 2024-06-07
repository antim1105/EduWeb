package com.example.demo.healper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JPopupMenu.Separator;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//public final String UPLOAD_DIR="C:\\Users\\Shudhanshu Jaiswal\\OneDrive\\Desktop\\JAVA\\Springboot\\bootrestbook\\src\\main\\resources\\static\\image";
	public final String UPLOAD_DIR = new ClassPathResource("static/img").getFile().getAbsolutePath();

	public FileUploadHelper() throws IOException {
	}

	public boolean uploadFile(MultipartFile f) {
		boolean f1 = false;
		try {
			Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + f.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f1 = true;
		} catch (Exception e) {

		}

		return f1;
	}
}
