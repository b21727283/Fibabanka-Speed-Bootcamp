package com.example.springbootfirst.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long teamId;
	private String teamName;
	
	@OneToMany(mappedBy="team", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Player> players;
	
	public Team(long teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}
	public Team() {
		super();
	}
	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	

}
