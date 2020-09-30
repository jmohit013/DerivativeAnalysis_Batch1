package com.derivative.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derivative.entity.FutureId;
import com.derivative.entity.Futures;

@Repository
public interface FuturesRepository extends JpaRepository<Futures, FutureId> {

}
