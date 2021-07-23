package com.cric.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cric.entity.User;
import com.cric.helper.Message;
import com.cric.repo.UserRepo;



@Controller
public class HomeController {
	@Autowired
	private BCryptPasswordEncoder passwordEncorder;
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title","home -smart contact Manager");
		return "home";
	}
	

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title","about -smart contact Manager");
		return "about";
	}
	@GetMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("Register","about -smart contact Manager");
		model.addAttribute("user",new User());
		return "signup";
	}
	//this handler for register user
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result1, @RequestParam(value="agreement",defaultValue="false") boolean agreement, Model model,
			HttpSession session){
		try {
			if(!agreement) 
			{
				System.out.print("you not agreed term and condition" );
				throw new Exception("you have not agreed term and condition");
			}
			if(result1.hasErrors()) 
			{
				model.addAttribute("user",user);
				return "signup";
			}
			
			user.setRole("ROLE_ACAD");
			user.setEnable(true);
			user.setImageaddress("default.png");
			user.setPassword(passwordEncorder.encode(user.getPassword()));
			System.out.print(agreement);
			System.out.print(user);
			User result=userRepo.save(user);
			model.addAttribute("user",new User());
			session.setAttribute("message", new Message("succesfull register","alert-succes"));
			return "signup";
		
			
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("something went wrong"+e.getMessage(),"alert-danger"));
			return "signup";
		}
		
		
		
	}
	
	@GetMapping("/signin")
	public String customLogin(Model model) 
	{
		model.addAttribute("title", "Login Page");
		return "login";
	}
}
