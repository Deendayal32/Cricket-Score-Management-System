package com.cric.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BatPerformance {
	
	@Id
	@GeneratedValue
	private int batId;
	private int pId;
	private String playerName;
	private int catchId;
	private int bowledId;
	private String dismissType;
	private int runs;
	private int balls;
	private int four;
	private int matchId;
	private int inning;
	
	
	public int getInning() {
		return inning;
	}
	public void setInning(int inning) {
		this.inning = inning;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getBatId() {
		return batId;
	}
	public void setBatId(int batId) {
		this.batId = batId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getCatchId() {
		return catchId;
	}
	public void setCatchId(int catchId) {
		this.catchId = catchId;
	}
	public int getBowledId() {
		return bowledId;
	}
	public void setBowledId(int bowledId) {
		this.bowledId = bowledId;
	}
	public String getDismissType() {
		return dismissType;
	}
	public void setDismissType(String dismissType) {
		this.dismissType = dismissType;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	public int getFour() {
		return four;
	}
	public void setFour(int four) {
		this.four = four;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	
}
