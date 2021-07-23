package com.cric.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class AddPlayer {
	
	@Id
	@GeneratedValue
	private int addId;
	private String playerName;
	private int playerId;
	private int teamId;
	private String playingOrNot;
	private String role;
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getPlayingOrNot() {
		return playingOrNot;
	}
	public void setPlayingOrNot(String playingOrNot) {
		this.playingOrNot = playingOrNot;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
