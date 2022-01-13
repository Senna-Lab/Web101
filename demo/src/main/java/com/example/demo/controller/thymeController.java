package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.BbsDTO;
import com.example.demo.model.BbsEntity;
import com.example.demo.service.BbsService;

@Controller
public class thymeController {
	
	@Autowired
	private BbsService bbsService;
	
	@RequestMapping(value="/thymeleaf", method=RequestMethod.GET)
	public String goHome(Model model) {
		
		bbsService.testBbsService();
		List<BbsEntity> entities = bbsService.findAll();
		
		List<BbsDTO> dtos = entities.stream().map(BbsDTO::new).collect(Collectors.toList());
		
		model.addAttribute("bbsDto", dtos);
		return "content/home";
	}
}
