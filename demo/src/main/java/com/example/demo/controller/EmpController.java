package com.example.demo.controller;

import java.util.ArrayList;
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

	@GetMapping("/jikchk")
	public ResponseEntity<?> getJikchk(){
		
		//DB에서 jikchk 가져오기
		List<String> jikchkList = service.findJikchk();
		
		List<BaseDTO> jikchkJsonList = new ArrayList<BaseDTO>();
		
		
		//jikgub 값을 json에 넣기. key를 "jikgub"으로 고정 ==> {"key":"jikgub", "value":"어쩌구"}, ....
				for(String s : jikchkList) {
					jikchkJsonList.add(new BaseDTO("jikchk", s));
				}
		
		return ResponseEntity.ok().body(jikchkJsonList);
	}

	@GetMapping("/jikgub")
	public ResponseEntity<?> getJikgub(){
		
		//DB에서 jikgub 가져오기
		List<String> jikgubList = service.findJikgub();
		
		

		List<BaseDTO> jikgubJsonList = new ArrayList<BaseDTO>();

		//jikgub 값을 json에 넣기. key를 "jikgub"으로 고정 ==> {"key":"jikgub", "value":"어쩌구"}, ....
		for(String s : jikgubList) {
			jikgubJsonList.add(new BaseDTO("jikgub", s));
		}


		
		return ResponseEntity.ok().body(jikgubJsonList);
	}
	
	@GetMapping("/jikgub2")
	public ResponseEntity<?> getJikgub2(){
		
		
		String tmp = "[{\"key\":\"jikgub\",\"value\":\"고문\"},{\"key\":\"jikgub\",\"value\":\"FC\"},{\"key\":\"jikgub\",\"value\":\"전무\"},{\"key\":\"jikgub\",\"value\":\"대리\"},{\"key\":\"jikgub\",\"value\":\"과장\"},{\"key\":\"jikgub\",\"value\":\"사원\"},{\"key\":\"jikgub\",\"value\":\"본부장\"},{\"key\":\"jikgub\",\"value\":\"주임\"},{\"key\":\"jikgub\",\"value\":\"부사장\"},{\"key\":\"jikgub\",\"value\":\"부장\"},{\"key\":\"jikgub\",\"value\":\"상무\"},{\"key\":\"jikgub\",\"value\":\"차장\"},{\"key\":\"jikgub\",\"value\":\"대표\"},";
		
		return ResponseEntity.ok().body(tmp);
	}

}
