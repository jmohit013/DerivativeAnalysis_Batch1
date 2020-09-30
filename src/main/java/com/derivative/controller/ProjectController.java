package com.derivative.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derivative.dto.PayOffCoordinates;
import com.derivative.dto.TradeEntityDto;
import com.derivative.entity.TradeEntity;
import com.derivative.pojo.User;
import com.derivative.service.ProjectService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/trades")
public class ProjectController {
	
	@Autowired
	ProjectService projectservice;
	

	@PostMapping(value="/login")
	public Boolean login(@RequestBody User user){
		return projectservice.login(user);
	}
	
	
	@PostMapping(value="/example",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public TradeEntity createNewTrade(@RequestBody TradeEntity tradeEntity) {
		return projectservice.createTrade(tradeEntity);
	}
	
	@PostMapping(value="/payoff",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public TradeEntityDto payOffChart(@RequestBody TradeEntity tradeEntity){
		return projectservice.levelOne(tradeEntity); 
	}
}




