package com.skumatov.palainteractive.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skumatov.palainteractive.entity.Game;
import com.skumatov.palainteractive.entity.GameDetail;
import com.skumatov.palainteractive.entity.Player;
import com.skumatov.palainteractive.repository.GameDaoRepository;
import com.skumatov.palainteractive.rest.error.EntityDetailNotFoundException;

@Repository
public class GameServiceImpl implements GameService {

	@Autowired
	GameDaoRepository gameDaoRepository;
	
	
	//persistence context
	private EntityManager entityManager;
		
	//constructor injection
	public GameServiceImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Game> findAll() {
		
		return gameDaoRepository.findAll();
	}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Game findById(Long theId) {
		Optional<Game> result = gameDaoRepository.findById(theId);
		Game theGame = null;
		if (result.isPresent()) {
			theGame = result.get();
			
		}else {
			return theGame;
		}
		logger.info("Game -> {}", theGame);
		return theGame;
	}

	@Override
	public String deleteById(Long theId) {

		Game theGame = entityManager.find(Game.class, theId);
		if (theGame == null) {
			throw new EntityDetailNotFoundException("Game's id not found - " +theId);
			
		}
		
		entityManager.remove(theGame);
		return "Deletet: " + theId;
	}
	
	@Override
	@Transactional
	public void save(Game theGame) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(theGame);
		
	}

}
