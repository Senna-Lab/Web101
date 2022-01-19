package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.EmpEntity;
import com.example.demo.persistence.EmpRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpService {
		
	@Autowired
	private EmpRepository repository;
	
	
	//Retrieve
		public List<EmpEntity> getEmpInfo(){
			
			return repository.findEmpInfo();
		}
	
		public List<String> findJikchk(){
			return repository.findJikchk();
		}

		public List<String> findJikgub(){
			return repository.findJikgub();
		}
}
