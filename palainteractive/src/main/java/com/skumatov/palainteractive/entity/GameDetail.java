package com.skumatov.palainteractive.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="game_detail")
public class GameDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long detail_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "created")
	private Date created;
	
	@Column(name = "type")
	private String type;
	
	//bi-directional relationship
	@OneToOne( fetch=FetchType.LAZY, mappedBy="game_detail",
			cascade=CascadeType.ALL)
	private Game game;

	public GameDetail() {
		
	}

	public GameDetail(String name, Date created, String type) {
		this.name = name;
		this.created = created;
		this.type = type;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Long getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(Long detail_id) {
		this.detail_id = detail_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "GameDetail [detail_id=" + detail_id + ", name=" + name + ", created=" + created + ", type=" + type
				+ "]";
	}
	
	

	
}
