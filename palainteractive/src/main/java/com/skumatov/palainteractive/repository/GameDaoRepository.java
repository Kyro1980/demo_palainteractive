package com.skumatov.palainteractive.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.skumatov.palainteractive.entity.Game;
//Spring Data JPA                                <Entity type, Primary key>
public interface GameDaoRepository  extends JpaRepository<Game, Long>{

}
