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
public class EmpDTO {
	
	private String emp_cd;
	private String emp_nm;
	private String perno;
	private String jikgub;
	private String jikchk;
	private String telno;
	private String hpno;
	private String mb_id;
	
	public EmpDTO(final EmpEntity entity) {
		this.emp_cd = entity.getEmp_cd();
		this.emp_nm = entity.getEmp_nm();
		this.perno = entity.getPerno();
		this.jikgub = entity.getJikgub();
		this.jikchk = entity.getJikchk();
		this.telno = entity.getTelno();
		this.hpno = entity.getHpno();
		this.mb_id = entity.getMb_id();
	}
	
	// Controller는 DTO로 요청바디를 받는다. 
	// 이를 Entity로 변환하여 Service에서 로직을 처리한 후... 다시 Entity를 받아 DTO로 변환하여 리턴해야 한다.
	// 그러므로 DTO를 Entity로 변환하는 메소드가 필요하다.
	public EmpEntity toEntity(final EmpDTO dto) {
		return EmpEntity.builder()
				.emp_cd(dto.getEmp_cd())
				.emp_nm(dto.getEmp_nm())
				.perno(dto.getPerno())
				.jikchk(dto.getJikchk())
				.jikgub(dto.getJikgub())
				.telno(dto.getTelno())
				.hpno(dto.getHpno())
				.mb_id(dto.getMb_id())
				.build();
	}
}