package com.derivative.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derivative.pojo.OptionId;
import com.derivative.pojo.Options;

@Repository
public interface OptionsRepository extends JpaRepository<Options, OptionId> {

}
