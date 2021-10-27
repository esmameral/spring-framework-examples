package com.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.form.GreetingForm;
import com.sample.model.City;
import com.sample.model.Greeting;
import com.sample.services.GreetingService;

@Controller
public class GreetingController {
	@Autowired
	GreetingService service;

	@PostMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, 
			@RequestParam(name="cityCode", required=true) String cityCode,Model model) {
		Greeting greeting=service.prepareGreeting(name,cityCode);
		List<String> townList=new ArrayList<String>();
		townList.add("Kadikoy");
		townList.add("uskudar");
		townList.add("Kartal");
		
		model.addAttribute("greeting", greeting);
		model.addAttribute("townList", townList);
		
		
		return "result";	
	}
	
	@GetMapping("/")
	public String home(Model model) {
		GreetingForm form = new GreetingForm();
	    model.addAttribute("greetingForm", form);
		List<City> cityList=new ArrayList<City>();
		cityList.add(new City("34","Istanbul"));
		cityList.add(new City("06","Ankara"));
		cityList.add(new City("35","İzmir"));
		
		model.addAttribute("cityList", cityList);
		return "home";	
	}
}
