package com.cric.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MatchResult {
	
	@Id
	@GeneratedValue
	private int resultid;
	private int mId;
	private int team1Score;
	private int team1Wicket;
	private int team2Wicket;
	private int team2Score;
	private String comment;
	
	public int getTeam1Wicket() {
		return team1Wicket;
	}
	public void setTeam1Wicket(int team1Wicket) {
		this.team1Wicket = team1Wicket;
	}
	public int getTeam2Wicket() {
		return team2Wicket;
	}
	public void setTeam2Wicket(int team2Wicket) {
		this.team2Wicket = team2Wicket;
	}
	public int getResultid() {
		return resultid;
	}
	public void setResultid(int resultid) {
		this.resultid = resultid;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public int getTeam1Score() {
		return team1Score;
	}
	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}
	public int getTeam2Score() {
		return team2Score;
	}
	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
