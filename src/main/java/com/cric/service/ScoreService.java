package com.cric.service;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.cric.entity.BallByBall;

public class ScoreService {
	public Model score(Model model ,Principal principal,BallByBall b ,boolean wide,boolean noball, boolean wicket, HttpServletRequest req) 
	{
		
		return model;
		
	}
}
