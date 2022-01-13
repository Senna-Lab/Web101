package com.example.demo.dto;

import java.sql.Timestamp;

import com.example.demo.model.BbsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BbsDTO {
	
	private Long id;
	private String userId;
	private String bbsTitle;
	private String bbsBody;
	private int thumbsUp;
	private int thumbsDown;
	private java.sql.Timestamp dateTimeField;
	
	public BbsEntity toEntity(final BbsDTO dto) {
		
		return BbsEntity.builder()
				.id(id)
				.userId(userId)
				.bbsTitle(bbsTitle)
				.bbsBody(bbsBody)
				.thumbsUp(thumbsUp)
				.thumbsDown(thumbsDown)
				.dateTimeField(dateTimeField)
				.build();
	}
	
}
