package com.skumatov.palainteractive.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skumatov.palainteractive.entity.GameDetail;
import com.skumatov.palainteractive.repository.GameDetailDaoRepository;
import com.skumatov.palainteractive.rest.error.EntityDetailNotFoundException;

@Repository
public class GameDetailServiceImpl implements GameDetailService {

	@Autowired
	GameDetailDaoRepository gameDetailDaoRepository;
	
	//persistence context
	private EntityManager entityManager;
	
	//constructor injection
	public GameDetailServiceImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
		
	}
	@Override
	@Transactional
	public List<GameDetail> findAll() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//create query
		Query<GameDetail> theQuery =
				currentSession.createQuery("from GameDetail", GameDetail.class);
		//execute query
		List<GameDetail> details = theQuery.getResultList();
		
		return details;
	}
	@Override
	@Transactional
	public GameDetail findById(Long theId) {
		Optional<GameDetail> result = gameDetailDaoRepository.findById(theId);
		GameDetail theGameDetail = null;
		if (result.isPresent()) {
			theGameDetail = result.get();
			
		}else {
			return theGameDetail;
		}
		return theGameDetail;

	}
	@Override
	@Transactional
	public String deleteById(Long theId) {
		
		GameDetail theGameDetail = entityManager.find(GameDetail.class, theId);
		if (theGameDetail == null) {
			throw new EntityDetailNotFoundException("Game detail id not found - " +theId);
			
		}
		
		entityManager.remove(theGameDetail);
		return "Deletet: " + theId;
	}


}
