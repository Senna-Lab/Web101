package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

	
	@GetMapping
	public String testController() {
		
		System.out.println("testController is running!");
		
		return "Hello Testing here";
	}
	
	@GetMapping("/testGetMapping")
	public String testControllerWithPath() {
		return "Testing with testGetMapping..";
	}
}