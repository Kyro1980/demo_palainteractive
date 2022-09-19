package com.skumatov.palainteractive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skumatov.palainteractive.entity.Player;

public interface PlayerDaoRepository   extends JpaRepository<Player, Long>{

}
