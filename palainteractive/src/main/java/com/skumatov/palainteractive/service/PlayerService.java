package com.skumatov.palainteractive.service;

import java.util.List;

import com.skumatov.palainteractive.entity.Player;

public interface PlayerService {
	public List<Player> findAll();
	public String deleteById(Long theId);
	public void save(Player thePlayer);
}
