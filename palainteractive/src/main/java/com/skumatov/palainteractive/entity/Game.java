package com.skumatov.palainteractive.entity;

import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="game")
public class Game {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long game_id;
	
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="game_detail_id")
	private GameDetail game_detail;
	
	@Column(name = "cpg")
	private int cpg;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
					CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
		name="game_player",
		joinColumns=@JoinColumn(name="game_id"),
		inverseJoinColumns=@JoinColumn(name="player_id")
	)
	private List<Player> players;

	public Game() {
	}

	public Game(GameDetail game_detail_id, int cpg) {
		this.game_detail = game_detail_id;
		this.cpg = cpg;
	}

	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	//add a player
	public void addPlayer(Player thePlayer) {
		if(players == null) {
			players = new ArrayList<>();
		}
		players.add(thePlayer);
	}
	
	public Long getGame_id() {
		return game_id;
	}

	public void setGame_id(Long game_id) {
		this.game_id = game_id;
	}

	public GameDetail getGame_detail() {
		return game_detail;
	}

	public void setGame_detail(GameDetail game_detail) {
		this.game_detail = game_detail;
	}

	public int getCpg() {
		return cpg;
	}

	public void setCpg(int cpg) {
		this.cpg = cpg;
	}

	@Override
	public String toString() {
		return "Game [game_id=" + game_id + ", game_detail=" + game_detail + ", cpg=" + cpg + "]";
	}
	
	
	
}
