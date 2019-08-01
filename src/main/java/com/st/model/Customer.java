package com.st.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="customer_tab")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="Cust_ID")
	private Integer cid;
	@Column(name="Cust_Name")
	private String custName;
	@Column(name="Cust_ServiceId")
	private String serviceId;
	@Column(name="Cust_Mode")
	private String mode;
}
