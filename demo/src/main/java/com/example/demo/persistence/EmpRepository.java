package com.example.demo.persistence;

import java.util.List;

import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.BaseDTO;
import com.example.demo.model.EmpEntity;




public interface EmpRepository extends JpaRepository<EmpEntity, String>{

	@Query("select new com.example.demo.model.EmpEntity(emp_cd, emp_nm, perno, jikgub, jikchk, telno, hpno) from EmpEntity order by emp_cd asc")
	List<EmpEntity> findEmpInfo();
	
	
	@Query("select distinct jikchk from EmpEntity" + 
			"		where jikchk != '' and jikchk is not null")
	List<String> findJikchk();
	
	@Query("select distinct jikgub from EmpEntity" + 
			"		where jikgub != '' and jikgub is not null")
	List<String> findJikgub();
	

		
}
