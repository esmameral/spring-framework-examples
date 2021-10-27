package com.example.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Instructor implements IPerson {
	@Override
	public String getNameById(int id) {
		return "Canan";
	}
}
