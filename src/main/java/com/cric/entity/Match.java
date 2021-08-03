package com.cric.entity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="matchtable")
public class Match implements Comparable<Match> {
	
	@Id
	@GeneratedValue
	private int mId;
	private String team2;
	private String team1;
	private int total1;
	private int total2;
	private int over;
	private float t1over;
	private float t2over;
	private int t1wicket;
	private int t2wicket;
	private int inning;
	private int total;
	private int ball;
	private LocalDate date=java.time.LocalDate.now();
	private String groundName;

	
	

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getGroundName() {
		return groundName;
	}
	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}
	public int getT1wicket() {
		return t1wicket;
	}
	public void setT1wicket(int t1wicket) {
		this.t1wicket = t1wicket;
	}
	public int getT2wicket() {
		return t2wicket;
	}
	public void setT2wicket(int t2wicket) {
		this.t2wicket = t2wicket;
	}
	public int getTotal2() {
		return total2;
	}
	public void setTotal2(int total2) {
		this.total2 = total2;
	}
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public int getTotal1() {
		return total1;
	}
	public void setTotal1(int total1) {
		this.total1 = total1;
	}
	public int getInning() {
		return inning;
	}
	public void setInning(int inning) {
		this.inning = inning;
	}
	public float getT1over() {
		return t1over;
	}
	public void setT1over(float t1over) {
		this.t1over = t1over;
	}
	public float getT2over() {
		return t2over;
	}
	public void setT2over(float t2over) {
		this.t2over = t2over;
	}
	public int getOver() {
		return over;
	}
	public void setOver(int over) {
		this.over = over;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	@Override
	public int compareTo(Match o) {
		// TODO Auto-generated method stub
		 return this.mId - o.mId;
	
	}
		
}
