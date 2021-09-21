package com.sample.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.sample.model.Greeting;

@Service
public class GreetingService {
	
	public Greeting prepareGreeting(String name, String city) {
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Greeting greeting=new Greeting();
		greeting.setName(name);
		greeting.setCity(city);
		greeting.setDate(df.format(new Date()));
		greeting.setMessage("Hello " + name+ "("+city+"), how are you?");
		return greeting;
	}
	

}
