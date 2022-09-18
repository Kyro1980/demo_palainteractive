package com.skumatov.palainteractive.service;

import java.util.List;

import com.skumatov.palainteractive.entity.Game;

//The Data Access Object (DAO) pattern is a structural 
// pattern that allows us to isolate the application/business layer
public interface GameService {

	public List<Game> findAll();
	public Game findById(Long id);
	public String deleteById(Long theId);
	public void save(Game theGame);
}
