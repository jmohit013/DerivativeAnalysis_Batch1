package com.derivative.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derivative.entity.TradeEntity;

@Repository
public interface TradeRepo extends JpaRepository<TradeEntity,Long> {

}
