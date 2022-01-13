package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BbsEntity;

@Repository
public interface BbsRepository extends JpaRepository<BbsEntity, String> {

	List<BbsEntity> findByUserId(String userId);
}
