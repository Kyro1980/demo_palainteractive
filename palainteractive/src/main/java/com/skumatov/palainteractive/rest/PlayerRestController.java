package com.skumatov.palainteractive.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skumatov.palainteractive.entity.Player;
import com.skumatov.palainteractive.service.PlayerService;

@RestController
@RequestMapping("/api")
public class PlayerRestController {
	
	@Autowired
	private PlayerService playerDAO;
	
	@GetMapping("/players")
	public List<Player> findAll(){
		return playerDAO.findAll();
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/players/delete/{playerId}")
	public String deleteDetail(@PathVariable long playerId) {
		return playerDAO.deleteById(playerId);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/players")
	public Player addPlayer(@RequestBody Player thePlayer) {
		// in case an id in JSON set to not 0
		thePlayer.setPlayer_id((long) 0);
		playerDAO.save(thePlayer);
		return thePlayer;
	}
}
