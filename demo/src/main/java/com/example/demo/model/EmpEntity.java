package com.example.demo.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.example.demo.dto.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tbin_empmst")
public class EmpEntity {
	
	@Id
	private String emp_cd;
	private String emp_nm;
	private String perno;
	private String jikgub;
	private String jikchk;
	private String telno;
	private String hpno;
	private String mb_id;
	
	
	public EmpEntity(String emp_cd, String emp_nm, String perno, String jikgub, String jikchk, String telno,
			String hpno) {
		super();
		this.emp_cd = emp_cd;
		this.emp_nm = emp_nm;
		this.perno = perno;
		this.jikgub = jikgub;
		this.jikchk = jikchk;
		this.telno = telno;
		this.hpno = hpno;
		this.mb_id="HSH";
	}
	
	
	
}
