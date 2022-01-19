package com.example.demo.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
/*
@NamedNativeQuery(name="Emp.findJikchk",
	query="select 'jikchk' as 'key', a.value\\r\\n\" + \r\n" + 
			"			\"	from (select distinct jikchk value\\r\\n\" + \r\n" + 
			"			\"		from tbin_empmst\\r\\n\" + \r\n" + 
			"			\"		where jikchk != '' and jikchk is not null) a",
	resultSetMapping="Mapping.BaseDTO")
@SqlResultSetMapping(name="Mappping.BaseDTO",
	classes= @ConstructorResult(targetClass = BaseDTO.class,
								columns= {
										@ColumnResult(name="key"),
										@ColumnResult(name="value")
								}))
								*/
public class baseEntity {


	private String key;
	
	@Id
	private String value;


}