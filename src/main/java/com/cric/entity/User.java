package com.cric.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotBlank(message="Name field is required")
	@Size(min=2,max=20, message="min 2 and max 20 character allowed!!")
	private String name;
	@Column(unique= true)
	private String email;
	private String password;
	private boolean enable;
	private String role;
	private String imageaddress;
	private String about;
	

	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
	private List<Team> teams = new ArrayList<>();
	
	
	 
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImageaddress() {
		return imageaddress;
	}
	public void setImageaddress(String imageaddress) {
		this.imageaddress = imageaddress;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", enable="
				+ enable + ", role=" + role + ", imageaddress=" + imageaddress + ", about=" + about + ", contacts="
				 + "]";
	}
	
	

}
