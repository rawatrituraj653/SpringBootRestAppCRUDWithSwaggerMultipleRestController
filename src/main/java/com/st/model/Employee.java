package com.st.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="EMP_TABLE")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="EMP_ID")
	private Integer eid;
	@Column(name="EMP_Name")
	private String ename;
	@Column(name="EMP_SAL")
	private Double esal;
}
