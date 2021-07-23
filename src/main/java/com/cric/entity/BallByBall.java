package com.cric.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class BallByBall {
	
	@Id
	@GeneratedValue
	private int bId;
	private int playerId;
	private int bowlerId;
	private int matchId;
	private int  run;
	private int extra;
	private String ballType;
	
	
	
	public int getExtra() {
		return extra;
	}
	public void setExtra(int extra) {
		this.extra = extra;
	}
	public String getBallType() {
		return ballType;
	}
	public void setBallType(String ballType) {
		this.ballType = ballType;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getBowlerId() {
		return bowlerId;
	}
	public void setBowlerId(int bowlerId) {
		this.bowlerId = bowlerId;
	}
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	

}
