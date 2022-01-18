package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
	
	
}
