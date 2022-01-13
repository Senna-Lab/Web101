package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BbsDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.BbsEntity;
import com.example.demo.service.BbsService;

@RestController
@RequestMapping("bbs")
public class BbsController {

	@Autowired
	private BbsService bbsService;
	
	@GetMapping
	public ResponseEntity<?> testBbs( final String userId){
		
		bbsService.testBbsService();
		List<BbsEntity> entities = bbsService.findAll();
		
		List<BbsDTO> dtos = entities.stream().map(BbsDTO::new).collect(Collectors.toList());

		ResponseDTO<BbsDTO> response = ResponseDTO.<BbsDTO>builder().data(dtos).build();
		
		return ResponseEntity.ok().body(response);
	}
	
	
}
