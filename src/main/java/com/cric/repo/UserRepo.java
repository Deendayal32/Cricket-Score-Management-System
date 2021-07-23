package com.cric.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cric.entity.User;



public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.email = :email")
	public User getUserByUserName(@Param("email") String email);

	public List<User> findByName(String name);

	public User getUserById(int id);


}
