package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;

@RestController
@RequestMapping("test")
public class TestController {

	@GetMapping
	public ResponseEntity<?> TestResponse() {
		
		//return "Hello testing here!";
		
		List<String> list = new ArrayList<>();
		list.add("hi");
		list.add("this is Senna, testing now!");
		
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		
		return ResponseEntity.ok().body(response);
		
	}
}
