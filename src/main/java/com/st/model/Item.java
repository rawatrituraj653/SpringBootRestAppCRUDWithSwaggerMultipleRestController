package com.st.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ITEM_TAB")
@Data
public class Item {

	@Id
	@GeneratedValue
	@Column(name="ITEM_ID")
	private Integer itemId;
	@Column(name="ITEM_NAME")
	private String itemName;
	@Column(name="ITEM_COST")
	private Double itemCost;
	@Column(name="ITEM_GST")
	private Integer gst;
}
