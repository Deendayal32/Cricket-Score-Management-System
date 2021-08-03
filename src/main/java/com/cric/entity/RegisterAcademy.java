package com.cric.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegisterAcademy {
	
	@Id
	private int aId;
	private String acadName;
	private String contact;
	private String img;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getAcadName() {
		return acadName;
	}
	public void setAcadName(String acadName) {
		this.acadName = acadName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
