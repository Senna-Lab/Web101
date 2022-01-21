package com.example.demo.persistence;

import java.util.List;
import java.util.Optional;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.BaseDTO;
import com.example.demo.model.EmpEntity;




public interface EmpRepository extends JpaRepository<EmpEntity, String>{

	@Query("select new com.example.demo.model.EmpEntity(emp_cd, emp_nm, perno, jikgub, jikchk, telno, hpno, mb_id) from EmpEntity where mb_id = 'HSH' order by emp_cd asc")
	List<EmpEntity> findEmpInfo();
	
	
	
	
	@Query(value= "select cd_vl, cd_vl_nm from tbcm_common_code tcc\r\n" + 
			"	where mb_id = 'HSH' and grp_cmm_cd = 'jikchk'", nativeQuery = true)
	List<Tuple> findJikchk();
	
	@Query(value= "select cd_vl, cd_vl_nm from tbcm_common_code tcc\r\n" + 
			"	where mb_id = 'HSH' and grp_cmm_cd = 'jikgub'", nativeQuery = true)
	List<Tuple> findJikgub();

	
	
	Optional<EmpEntity> findById(String emp_cd);
	
	
		
}
