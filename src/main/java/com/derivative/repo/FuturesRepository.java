package com.derivative.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derivative.pojo.FutureId;
import com.derivative.pojo.Futures;

@Repository
public interface FuturesRepository extends JpaRepository<Futures, FutureId> {

}
