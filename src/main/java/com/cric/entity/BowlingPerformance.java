package com.cric.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BowlingPerformance {
	
	@Id
	@GeneratedValue
	private int bPerformId;
	private int mId;
	private int playerId;
	private float over;
	private int maiden;
	private int runs;
	private int wicket;
	public int getbPerformId() {
		return bPerformId;
	}
	public void setbPerformId(int bPerformId) {
		this.bPerformId = bPerformId;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public float getOver() {
		return over;
	}
	public void setOver(float over) {
		this.over = over;
	}
	public int getMaiden() {
		return maiden;
	}
	public void setMaiden(int maiden) {
		this.maiden = maiden;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWicket() {
		return wicket;
	}
	public void setWicket(int wicket) {
		this.wicket = wicket;
	}
	
}
