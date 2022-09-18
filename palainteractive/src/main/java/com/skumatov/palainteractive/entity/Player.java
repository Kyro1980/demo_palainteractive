package com.skumatov.palainteractive.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long player_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "email")
	private String email;
	
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
					CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
		name="game_player",
		joinColumns=@JoinColumn(name="player_id"),
		inverseJoinColumns=@JoinColumn(name="game_id")
	)
	private List<Game> games;

	
	
	public Player() {
	}

	
	public Player(String first_name, String last_name, String email, List<Game> games) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.games = games;
	}




	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Long getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
