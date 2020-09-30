package com.derivative.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derivative.entity.OptionId;
import com.derivative.entity.Options;

@Repository
public interface OptionsRepository extends JpaRepository<Options, OptionId> {

}
