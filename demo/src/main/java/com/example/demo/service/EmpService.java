package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;
import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BaseDTO;
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
	
		//직책
		public List<BaseDTO> findJikchk(){
			
			List<Tuple> tuples = repository.findJikchk();
			
			List<BaseDTO> dtos = tuples.stream().map( t -> 
														new BaseDTO(t.get(0, String.class), t.get(1, String.class))
													)
													.collect(Collectors.toList());
			
			
			return dtos;
		}

		//직급
		public List<BaseDTO> findJikgub(){

			List<Tuple> tuples = repository.findJikgub();
			
			List<BaseDTO> dtos = tuples.stream().map( t -> 
														new BaseDTO(t.get(0, String.class), t.get(1, String.class))
													)
													.collect(Collectors.toList());
			
			
			return dtos;
		}
		
		
	//Create
	public EmpEntity createEmpInfo(final EmpEntity empEntity){
		
		repository.save(empEntity);
		log.info("EmpEntity Code : {} is saved.", empEntity.getEmp_cd());
		
		return repository.findById(empEntity.getEmp_cd()).get();
	}
	
	//Update
	public EmpEntity updateEmpInfo(final EmpEntity empEntity){
		
		//넘겨받은 emp_cd를 통해 해당 empEntity를 가져온다.
		final Optional<EmpEntity> original = repository.findById(empEntity.getEmp_cd());
		
		original.ifPresent( emp -> {
			emp.setEmp_cd(empEntity.getEmp_cd());
			emp.setEmp_nm(empEntity.getEmp_nm());
			emp.setPerno(empEntity.getPerno());
			emp.setJikchk(empEntity.getJikchk());
			emp.setJikgub(empEntity.getJikgub());
			emp.setTelno(empEntity.getTelno());
			emp.setHpno(empEntity.getHpno());
			
			repository.save(emp);
		});
		
		
		return repository.findById(empEntity.getEmp_cd()).get();  //Optional<T>.get() ==> Optional 객체에 저장된 값에 접근. isPresent() 메소드를 이용하여 좀 더 안전하게 접근할 수도 있음.
	}
	
	//Delete
	public List<EmpEntity> deleteEmpInfo(final EmpEntity empEntity){
		
		
		try {
			repository.delete(empEntity);
			
		}catch (Exception e) {
			// TODO: handle exception
			log.error("error deleting eneity.",  empEntity.getEmp_cd(), e);
			
			throw new RuntimeException("error deleting entity "+empEntity.getEmp_cd());
		}
		
		return getEmpInfo();
		
	}
}
