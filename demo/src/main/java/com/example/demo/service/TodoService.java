package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodoService {
		
	@Autowired
	private TodoRepository repository;
	
	
	//Retrieve
		public List<TodoEntity> retrieve(){
			return repository.findAll();
		}
	
}
