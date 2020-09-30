package com.derivative.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.derivative.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByName(String name);
}
