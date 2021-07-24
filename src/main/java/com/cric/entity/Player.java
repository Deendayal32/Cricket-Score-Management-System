package com.cric.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String striker;
	private String nonstriker;
	private String bowler;
	private int bRun;
	private float bover;
	private int over;
	private int sRun;
	private int nSRun;
	private int wiket;
	private int sfour;
	private int sball;
	private int nsBall;
	private int sSix;
	private int nsfour;
	private int nssix;
	public List<String> thisOver=new ArrayList<>();
	
	
    
	public int getbRun() {
		return bRun;
	}
	public void setbRun(int bRun) {
		this.bRun = bRun;
	}
	public float getBover() {
		return bover;
	}
	public void setBover(float bover) {
		this.bover = bover;
	}
	public int getOver() {
		return over;
	}
	public void setOver(int over) {
		this.over =  over;
	}
	public int getSball() {
		return sball;
	}
	public void setSball(int sball) {
		this.sball = sball;
	}
	public int getNsBall() {
		return nsBall;
	}
	public void setNsBall(int nsBall) {
		this.nsBall = nsBall;
	}
	public List<String> getThisOver() {
		return thisOver;
	}
	public void setThisOver(List<String> thisOver) {
		this.thisOver = thisOver;
	}
	public int getSfour() {
		return sfour;
	}
	public void setSfour(int sfour) {
		this.sfour = sfour;
	}
	public int getsSix() {
		return sSix;
	}
	public void setsSix(int sSix) {
		this.sSix = sSix;
	}
	public int getNsfour() {
		return nsfour;
	}
	public void setNsfour(int nsfour) {
		this.nsfour = nsfour;
	}
	public int getNssix() {
		return nssix;
	}
	public void setNssix(int nssix) {
		this.nssix = nssix;
	}
	
	public int getWiket() {
		return wiket;
	}
	public void setWiket(int wiket) {
		this.wiket = wiket;
	}
	public int getsRun() {
		return sRun;
	}
	public void setsRun(int sRun) {
		this.sRun = sRun;
	}
	public int getnSRun() {
		return nSRun;
	}
	public void setnSRun(int nSRun) {
		this.nSRun = nSRun;
	}
	public String getStriker() {
		return striker;
	}
	public void setStriker(String striker) {
		this.striker = striker;
	}
	public String getNonstriker() {
		return nonstriker;
	}
	public void setNonstriker(String nonstriker) {
		this.nonstriker = nonstriker;
	}
	public String getBowler() {
		return bowler;
	}
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}
	
	
}
