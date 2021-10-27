package com.example.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TeachingAssistant implements IPerson {
	@Override
	public String getNameById(int id) {
		return "Cemil";
	}
}
