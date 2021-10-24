package com.sample.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
		List<String> townList=new ArrayList<String>();
		townList.add("Kadikoy");
		townList.add("uskudar");
		townList.add("Kartal");
		
		model.addAttribute("greeting", greeting);
		model.addAttribute("townList", townList);
		
		
		return "result";
		
	}
}
