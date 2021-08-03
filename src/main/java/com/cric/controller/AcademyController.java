package com.cric.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cric.entity.RegisterAcademy;
import com.cric.repo.AcadmyRegister;
import com.cric.service.FileUploadUtil;


@Controller
@RequestMapping("/academy")
public class AcademyController {
	
	@Autowired
	AcadmyRegister aR;
	
	@RequestMapping("/dashboard")
	public String dashbord() {
		
		return "academy/index";
		
	}
	
	@RequestMapping("/acadregister")
	public String register(RegisterAcademy rA , MultipartFile file) throws IOException 
	{
		String uploadDir = "C:\\Users\\Deenu\\git\\task1\\employeeManagement\\src\\main\\webapp\\img" ;
		String fileName = file.getOriginalFilename();
		rA.setImg(fileName);
	    FileUploadUtil.saveFile(uploadDir, fileName, file);
		aR.save(rA);
		return "";
	}

}
