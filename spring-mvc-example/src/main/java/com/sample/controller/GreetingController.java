package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.model.Greeting;
import com.sample.services.GreetingService;

@Controller
public class GreetingController {
	@Autowired
	GreetingService service;

	@PostMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, 
			@RequestParam(name="city", required=true) String city,Model model) {
		Greeting greeting=service.prepareGreeting(name,city);
		model.addAttribute("greeting", greeting);
		return "result";
	}
}
