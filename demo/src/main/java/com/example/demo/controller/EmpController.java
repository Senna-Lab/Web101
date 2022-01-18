package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.model.EmpEntity;
import com.example.demo.model.TodoEntity;
import com.example.demo.service.EmpService;
import com.example.demo.service.TodoService;


@RestController
@RequestMapping("api")
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping
	public ResponseEntity<?> getEmp(){
		

		List<EmpEntity> entities = service.getEmpInfo();
		
		//2. 자바 스트림을 이용해 리턴된 엔티티 리스트를 DTO리스트로 변환한다.
		List<EmpDTO> dtos = entities.stream().map(EmpDTO::new).collect(Collectors.toList());
		
		
		return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping("/jikchk")
	public ResponseEntity<?> getJikchk(){
		
		
		List<String> jikchkList = service.findJikchk();
		
		
		
		return ResponseEntity.ok().body(jikchkList);
	}
	
	@GetMapping("/jikgub")
	public ResponseEntity<?> getJikgub(){
		
		//1. 서비스 베소드의 retrieve() 메소드를 사용해 Todo 리스트를 가져온다. 
		//token 추가 후 수정: userId로 설정!
		List<String> jikgubList = service.findJikgub();
		
		
		
		return ResponseEntity.ok().body(jikgubList);
	}


}
