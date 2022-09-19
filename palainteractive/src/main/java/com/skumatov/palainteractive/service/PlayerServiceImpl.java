package com.skumatov.palainteractive.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skumatov.palainteractive.entity.Game;
import com.skumatov.palainteractive.entity.Player;
import com.skumatov.palainteractive.repository.PlayerDaoRepository;
import com.skumatov.palainteractive.rest.error.EntityDetailNotFoundException;

@Repository
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	PlayerDaoRepository playerDaoRepository;
	
	//persistence context
	private EntityManager entityManager;
		
	//constructor injection
	public PlayerServiceImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Player> findAll() {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//create query
		Query<Player> theQuery =
				currentSession.createQuery("from Player", Player.class);
		List<Player> players = theQuery.getResultList();
		
		return players;
	}
	
	@Override
	@Transactional
	public String deleteById(Long theId) {
		
		Player thePlayer = entityManager.find(Player.class, theId);
		if (thePlayer == null) {
			throw new EntityDetailNotFoundException("Game detail id not found - " +theId);
			
		}
		
		entityManager.remove(thePlayer);
		return "Deleted player id: " + theId;
	}

	@Override
	@Transactional
	public void save(Player thePlayer) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		if(thePlayer.getGames() != null && thePlayer.getGames().size() > 0) {
			List<Game> games = new ArrayList<Game>();
			thePlayer.setGames(games);
		}
		
		
		currentSession.save(thePlayer);
		
	}

	@Override
	@Transactional
	public Player findById(Long theId) {
		Optional<Player> result = playerDaoRepository.findById(theId);
		Player thePlayer = null;
		if (result.isPresent()) {
			thePlayer = result.get();
			
		}else {
			return thePlayer;
		}
		return thePlayer;
	}
	
}
