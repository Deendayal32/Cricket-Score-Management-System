package com.cric.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cric.entity.User;
import com.cric.repo.UserRepo;



public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepo.getUserByUserName(username);
		
		if(user==null) 
		{
			throw new UsernameNotFoundException("could not find user !!");
			
		}
		
		CustomUserDetails customUserDetails= new CustomUserDetails(user);
		
		return customUserDetails;
	}

}
