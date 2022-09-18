package com.skumatov.palainteractive.service;

import java.util.List;

import com.skumatov.palainteractive.entity.GameDetail;

public interface GameDetailService {
	
	public List<GameDetail> findAll();
	public GameDetail findById(Long theId);
	public String deleteById(Long theId);

}
