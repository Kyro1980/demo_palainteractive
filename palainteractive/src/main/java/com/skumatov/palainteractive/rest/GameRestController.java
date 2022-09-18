package com.skumatov.palainteractive.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skumatov.palainteractive.entity.Game;
import com.skumatov.palainteractive.rest.error.EntityDetailNotFoundException;
import com.skumatov.palainteractive.rest.error.EntityErrorResponse;
import com.skumatov.palainteractive.rest.error.GameDetailErrorResponse;
import com.skumatov.palainteractive.rest.error.GameDetailNotFoundException;
import com.skumatov.palainteractive.service.GameService;

@RestController
@RequestMapping("/api")
public class GameRestController {
	
	@Autowired
	private GameService gameDao;
	
	@GetMapping("/games")
	public List<Game> findAll(){
		return gameDao.findAll();
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping("/games/{gamesId}")
	public Game getPlacement(@PathVariable long gamesId) {
		Game theGame = gameDao.findById(gamesId);
	    	
	    if(theGame == null) {
	    	throw new EntityDetailNotFoundException("Game id not found - " +gamesId);
	    }
	    	
	     return theGame;	
	}	
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/games/delete/{detailsId}")
	public String deleteGame(@PathVariable long detailsId) {
		return gameDao.deleteById(detailsId);
	}
}
