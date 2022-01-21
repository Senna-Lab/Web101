package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.dto.BaseDTO;
import com.example.demo.model.EmpEntity;
import com.example.demo.model.TodoEntity;
import com.example.demo.service.EmpService;
import com.example.demo.service.TodoService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


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
	
	
	
	
	@PostMapping
	public ResponseEntity<?> createEmp(@RequestBody EmpDTO dto){
		
		try {
			EmpEntity entity = dto.toEntity(dto);
			
			//서비스에서 EmpEntity 생성
			//List<EmpEntity> entities = service.createEmpInfo(entity);
			EmpEntity entity2 = service.createEmpInfo(entity);
			
			//List<EmpDTO> dtos = entities.stream().map(EmpDTO::new).collect(Collectors.toList());
			//ResponseDTO<EmpDTO> response = ResponseDTO.<EmpDTO>builder().data(dtos).build();
			
			return ResponseEntity.ok().body(entity2);
		} catch (Exception e) {
			String error = e.getMessage();
			ResponseDTO<EmpDTO> response = ResponseDTO.<EmpDTO>builder().error(error).build();
			
			return ResponseEntity.badRequest().body(response);
		}
		
		
	}
	
	@PutMapping
	public ResponseEntity<?> updateEmp(@RequestBody EmpDTO dto){
		
		
		
		System.out.println(dto);
		
		
		EmpEntity entity = dto.toEntity(dto);
	
		//List<EmpEntity> entities = service.updateEmpInfo(entity);
		EmpEntity entity2 = service.updateEmpInfo(entity);
		
		//List<EmpDTO> dtos = entities.stream().map(EmpDTO::new).collect(Collectors.toList());
		//ResponseDTO<EmpDTO> response = ResponseDTO.<EmpDTO>builder().data(dtos).build();
		
		return ResponseEntity.ok().body(entity2);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteEmp(@RequestBody EmpDTO dto){
		
		try {
			EmpEntity entity = dto.toEntity(dto);
			
			//서비스에서 EmpEntity 생성
			List<EmpEntity> entities = service.deleteEmpInfo(entity);
			
			List<EmpDTO> dtos = entities.stream().map(EmpDTO::new).collect(Collectors.toList());
			ResponseDTO<EmpDTO> response = ResponseDTO.<EmpDTO>builder().data(dtos).build();
			
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			String error = e.getMessage();
			ResponseDTO<EmpDTO> response = ResponseDTO.<EmpDTO>builder().error(error).build();
			
			return ResponseEntity.badRequest().body(response);
		}
		
		
	}
	
	
	
	
	
	
	
	
	//-----------------------
	
/*
	@GetMapping("/jikchk2")
	public ResponseEntity<?> getJikchk2(){
		
		//DB에서 jikchk 가져오기
		List<String> jikchkList = service.findJikchk();
		
		List<BaseDTO> jikchkJsonList = new ArrayList<BaseDTO>();
		
		
		//jikchk 값을 json에 넣기. key를 "jikchk"으로 고정 ==> {"key":"jikchk", "value":"어쩌구"}, ....
				for(String s : jikchkList) {
					jikchkJsonList.add(new BaseDTO("jikchk", s));
				}
		
		return ResponseEntity.ok().body(jikchkJsonList);
	}
	*/
	
	@GetMapping("/jikchk")
	public ResponseEntity<?> getJikchk(){
		
		//DB에서 jikchk 가져오기
		List<BaseDTO> jikchkList = service.findJikchk();
		
		
		return ResponseEntity.ok().body(jikchkList);
	}

	@GetMapping("/jikgub")
	public ResponseEntity<?> getJikgub(){
		
		//DB에서 jikgub 가져오기
		List<BaseDTO> jikgubList = service.findJikgub();

		
		return ResponseEntity.ok().body(jikgubList);
	}
	

}
