package com.cric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/academy")
public class AcademyController {
	
	@RequestMapping("/dashboard")
	public String dashbord() {
		
		return "academy/signup";
		
	}

}
