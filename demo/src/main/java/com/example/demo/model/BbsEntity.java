package com.example.demo.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
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
@Table(name="BBS")
@SequenceGenerator(
	name="BBS_SEQ_GEN", //������ ���ʷ����� �̸�
	sequenceName="BBS_SEQ", //������ �̸�
	initialValue=1, //���۰�
	allocationSize=1 //�޸𸮸� ���� �Ҵ��� ���� ������
		)
public class BbsEntity {
		
		@Id
		@GeneratedValue(generator="BBS_SEQ_GEN", strategy=GenerationType.SEQUENCE)
		private Long id;
		
		private String userId;
		private String bbsTitle;
		private String bbsBody;
		private int thumbsUp;
		private int thumbsDown;
		
		@Column(name="DATETIME_FIELD")
		private java.sql.Timestamp dateTimeField;
		
		@ColumnDefault("0")
		private boolean deleted;
	
}
