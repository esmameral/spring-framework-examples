package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class Student implements IPerson {
	@Override
	public String getNameById(int id) {
		return "Ahmet";
	}
}
