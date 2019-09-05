package com.jorgetchira.celebrity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorgetchira.celebrity.service.ICelebrityService;

/**
 * @author Jorge Tchira
 * 
 * Rest API with celebrity services
 *
 */
@RestController
@RequestMapping("/celebrityapi")
public class CelebrityController {
	
	/**
	 * Celebrity Service implementation reference
	 */
	@Autowired
	public ICelebrityService celebrityService;
	
	/**
	 * Path to find a celebrity
	 * 
	 * @return the celebrity
	 */
	@GetMapping("/celebrity")
	public String findCelebrity() {
		return "THE CELEBRITY IS: "+celebrityService.findCelebrity();
	}

}
