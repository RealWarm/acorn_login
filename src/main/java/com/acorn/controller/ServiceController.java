package com.acorn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;


@Log4j
@RequestMapping("/service/*")
@Controller
public class ServiceController {
	
	
	@GetMapping("A")
	public void doA() {
		log.info("ServiceController::doA() invoked.");
	} // doA

} // end class
