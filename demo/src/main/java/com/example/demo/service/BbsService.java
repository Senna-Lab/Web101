package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BbsEntity;
import com.example.demo.persistence.BbsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BbsService {
	
	@Autowired
	private BbsRepository repository;
	
	public BbsEntity testBbsService() {
		BbsEntity entity = BbsEntity.builder()
				.bbsTitle("�����Դϴ�..")
				.bbsBody("�Խ��� ���빰�Դϴ�.")
				.thumbsUp(3)
				.thumbsDown(1)
				.dateTimeField(new Timestamp(System.currentTimeMillis()))
				.build();
		
		
		
		return entity;
	}
	
	public List<BbsEntity> retrieve(final String userId) {
		
		
		
		return repository.findByUserId(userId);
	}
}
