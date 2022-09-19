package com.skumatov.palainteractive.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skumatov.palainteractive.entity.GameDetail;
import com.skumatov.palainteractive.entity.Player;
import com.skumatov.palainteractive.rest.error.EntityDetailNotFoundException;
import com.skumatov.palainteractive.service.GameDetailService;

@RestController
@RequestMapping("/api")
public class GameDetailRestController {

	@Autowired
	private GameDetailService gameDetailDAO;
	
	@GetMapping("/details")
	public List<GameDetail> findAll(){
		return gameDetailDAO.findAll();
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping("/details/{detailsId}")
	public GameDetail getDetails(@PathVariable long detailsId) {
		GameDetail theGameDetail = gameDetailDAO.findById(detailsId);
	    	
	    if(theGameDetail == null) {
	    	throw new EntityDetailNotFoundException("Game detail id not found - " +detailsId);
	    }
	    	
	     return theGameDetail;	
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/details/delete/{detailsId}")
	public String deleteDetail(@PathVariable long detailsId) {
		return gameDetailDAO.deleteById(detailsId);
	}
	
	 
//	@CrossOrigin(origins = "*")
//	@PostMapping("/details")
//	public GameDetail addGameDetail(@RequestBody GameDetail GameDetail) {
//		//TO DO add game details
//		return null;
//	}
//	
//	@CrossOrigin(origins = "*")
//	@PutMapping("/details")
//	public GameDetail updateGameDetail(@RequestBody GameDetail GameDetail) {
//		//TO DO update existing game details 
//		return null;
//	}
}
