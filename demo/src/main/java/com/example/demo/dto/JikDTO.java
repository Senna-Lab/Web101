package com.example.demo.dto;

import com.example.demo.model.EmpEntity;
import com.example.demo.model.TodoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JikDTO {
	

	private String jikgub;
	private String jikchk;
}