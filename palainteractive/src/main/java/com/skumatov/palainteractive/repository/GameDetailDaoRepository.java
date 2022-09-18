package com.skumatov.palainteractive.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.skumatov.palainteractive.entity.Game;
import com.skumatov.palainteractive.entity.GameDetail;
//Spring Data JPA                                <Entity type, Primary key>
public interface GameDetailDaoRepository  extends JpaRepository<GameDetail, Long>{

}
